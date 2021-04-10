package vc.example.spring.boot.web.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author xiaolei.fu
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@SpringBootApplication
public class SimpleWebApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(SimpleWebApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .listeners(event -> {
                    log.warn("listener name:{}, source:{}, time:{}", event.getClass().getSimpleName(), event.getSource(), event.getTimestamp());
                }).run(args);
    }
}
