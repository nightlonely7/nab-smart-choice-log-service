package au.com.nab.smartchoice.logservice.dto.mapper;

import au.com.nab.smartchoice.logservice.dto.entity.HttpLogEntity;
import au.com.nab.smartchoice.logservice.dto.kafkamessage.HttpLogKafkaMessage;
import au.com.nab.smartchoice.logservice.dto.model.HttpLogModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Map;

@Mapper
public interface HttpLogMapper {
    HttpLogModel kafkaMessageToModel(HttpLogKafkaMessage httpLogKafkaMessage);

    @Mapping(target = "lastUpdatedAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "available", ignore = true)
    HttpLogEntity modelToEntity(HttpLogModel httpLogModel);

    default String mapToString(Map<String, Object> map) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
