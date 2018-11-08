package com.book.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: 一点点
 * @Date: 2018/11/4 20:40
 * @Version 1.0
 */
@Configuration
@PropertySource(value = "classpath:config.properties")
@ConfigurationProperties(prefix = "com.user")
@Data
public class User {

    private String name;
    private int age;
}
