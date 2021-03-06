package au.com.nab.smartchoice.logservice.dto.kafkamessage;

import au.com.nab.smartchoice.logservice.utility.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class HttpLogKafkaMessage {

    @JsonProperty("log_id")
    private String logId;

    @JsonProperty("request_line")
    private String requestLine;

    @JsonProperty("response_status")
    private Integer responseStatus;

    @JsonProperty("src_ip")
    private String srcIp;

    @JsonProperty("des_ip")
    private String desIp;

    @JsonProperty("request_body")
    private String requestBody;

    @JsonProperty("response_body")
    private String responseBody;

    @JsonProperty("request_header")
    private Map<String, Object> requestHeader;

    @JsonProperty("response_header")
    private Map<String, Object> responseHeader;

    @JsonProperty("requested_at")
    @JsonFormat(pattern = Constant.DATE_TIME_FORMAT)
    private LocalDateTime requestedAt;

    @JsonProperty("responded_at")
    @JsonFormat(pattern = Constant.DATE_TIME_FORMAT)
    private LocalDateTime respondedAt;
}
