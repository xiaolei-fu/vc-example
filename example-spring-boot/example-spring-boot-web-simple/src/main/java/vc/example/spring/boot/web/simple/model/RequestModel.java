package vc.example.spring.boot.web.simple.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 *
 * @author xiaolei.fu
 * @since 2021-04-10 19:47
 */
@Data
public class RequestModel {
    private String name;
    private Integer age;
    // request 格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // response 格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    private LocalDateTime local;
    private ZonedDateTime zoned;
}
