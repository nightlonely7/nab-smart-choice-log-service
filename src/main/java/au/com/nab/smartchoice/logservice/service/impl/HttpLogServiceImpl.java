package au.com.nab.smartchoice.logservice.service.impl;

import au.com.nab.smartchoice.logservice.dto.mapper.HttpLogMapper;
import au.com.nab.smartchoice.logservice.dto.model.HttpLogModel;
import au.com.nab.smartchoice.logservice.repository.HttpLogRepository;
import au.com.nab.smartchoice.logservice.service.HttpLogService;
import au.com.nab.smartchoice.logservice.utility.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static au.com.nab.smartchoice.logservice.utility.Constant.notFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class HttpLogServiceImpl implements HttpLogService {

    private final HttpLogRepository httpLogRepository;
    private final HttpLogMapper httpLogMapper;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public HttpLogModel save(HttpLogModel httpLogModel) {
        if (httpLogRepository.existsByLogId(httpLogModel.getLogId())) {
            var httpLogEntity = httpLogRepository.findByLogId(httpLogModel.getLogId())
                    .orElseThrow(notFoundException("logId", httpLogModel.getLogId()));
            httpLogEntity.setRespondedAt(httpLogModel.getRespondedAt());
            httpLogEntity.setResponseStatus(httpLogModel.getResponseStatus());
            httpLogEntity.setResponseBody(httpLogModel.getResponseBody());
            httpLogEntity.setResponseHeader(objectMapper.writeValueAsString(httpLogModel.getResponseHeader()));
            httpLogEntity.setLastUpdatedAt(LocalDateTime.now());
            httpLogRepository.save(httpLogEntity);
        } else {
            var httpLogEntity = httpLogMapper.modelToEntity(httpLogModel);
            httpLogEntity.setCreatedAt(LocalDateTime.now());
            httpLogEntity.setLastUpdatedAt(LocalDateTime.now());
            httpLogEntity.setAvailable(Boolean.TRUE);
            httpLogRepository.save(httpLogEntity);
        }
        return httpLogModel;
    }
}
