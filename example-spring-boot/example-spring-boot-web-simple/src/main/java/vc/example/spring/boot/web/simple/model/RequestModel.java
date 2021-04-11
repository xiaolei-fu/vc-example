package vc.example.spring.boot.web.simple.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author xiaolei.fu
 * @since 2021-04-10 19:47
 */
@Data
public class RequestModel {
    private String name;
    private Integer age;
    /**
     * <h2>GET</h2>
     * 默认: Sat，12 Aug 1995 13:30:00 GMT
     * <p>
     * request: @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     * </p>
     * <p>
     * response: @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     * </p>
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    private LocalDateTime local;
    /**
     * 必须带时区标记
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime zoned;
    private RequestModel child;
}
