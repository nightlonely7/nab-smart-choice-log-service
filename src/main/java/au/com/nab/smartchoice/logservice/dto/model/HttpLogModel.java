package au.com.nab.smartchoice.logservice.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class HttpLogModel {
    private String logId;
    private String requestLine;
    private Integer responseStatus;
    private String srcIp;
    private String desIp;
    private String requestBody;
    private String responseBody;
    private Map<String, Object> requestHeader;
    private Map<String, Object> responseHeader;
    private LocalDateTime requestedAt;
    private LocalDateTime respondedAt;
}
