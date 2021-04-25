package au.com.nab.smartchoice.logservice.input.kafkalistener;

import au.com.nab.smartchoice.logservice.configuration.kafka.TopicConfiguration;
import au.com.nab.smartchoice.logservice.dto.kafkamessage.HttpLogKafkaMessage;
import au.com.nab.smartchoice.logservice.dto.mapper.HttpLogMapper;
import au.com.nab.smartchoice.logservice.service.HttpLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LogKafkaListener {

    private final ObjectMapper objectMapper;
    private final HttpLogMapper httpLogMapper;
    private final HttpLogService httpLogService;

    @KafkaListener(topics = TopicConfiguration.LOG_TOPIC, groupId = "1")
    public void logListener(String message) {
        try {
            var httpLogKafkaMessage = objectMapper.readValue(message, HttpLogKafkaMessage.class);
            var httpLogModel = httpLogMapper.kafkaMessageToModel(httpLogKafkaMessage);
            httpLogService.save(httpLogModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
