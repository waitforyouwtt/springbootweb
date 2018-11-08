package com.book.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: 一点点
 * @Date: 2018/11/4 20:29
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "my")
@Data
public class ConfigBean {

    private String name;
    private Integer age;
    private Integer number;
    private String uuid;
    private int max;
    private String value;
    private String greeting;
}
