package vc.example.spring.boot.web.simple.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vc.example.spring.boot.web.simple.model.RequestModel;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.Optional;

/**
 * @author xiaolei.fu
 * @since 2021-04-10 19:46
 */
@Slf4j
@RestController
public class DateParamRestController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        // 自定义 request 属性format
        PropertyEditor datePe = new PropertyEditorSupport() {
            @Override
            public String getAsText() {
                Date value = (Date) getValue();
                return (value != null ? String.valueOf(value.getTime()) : null);
            }

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (!StringUtils.hasText(text)) {
                    // Treat empty String as null value.
                    setValue(null);
                }
                long time = Long.parseLong(text);
                setValue(new Date(time));
            }
        };

//        webDataBinder.registerCustomEditor(Date.class, datePe);

    }

    @RequestMapping({"", "/"})
    public RequestModel get(RequestModel model1, @RequestBody(required = false) RequestModel model2) {
        return Optional.ofNullable(model1).orElse(model2);
    }
}
