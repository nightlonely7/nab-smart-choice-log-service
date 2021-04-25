package au.com.nab.smartchoice.logservice.dto.entity;

import au.com.nab.smartchoice.logservice.utility.Constant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "http_log")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HttpLogEntity extends BaseEntity {

    @Column(name = "log_id")
    private String logId;

    @Column(name = "request_line")
    private String requestLine;

    @Column(name = "response_status")
    private Integer responseStatus;

    @Column(name = "src_ip")
    private String srcIp;

    @Column(name = "des_ip")
    private String desIp;

    @Column(name = "request_body", columnDefinition = "TEXT")
    private String requestBody;

    @Column(name = "response_body", columnDefinition = "TEXT")
    private String responseBody;

    @Column(name = "request_header", columnDefinition = "TEXT")
    private String requestHeader;

    @Column(name = "response_header", columnDefinition = "TEXT")
    private String responseHeader;

    @Column(name = "requested_at")
    private LocalDateTime requestedAt;

    @Column(name = "responded_at")
    private LocalDateTime respondedAt;
}
