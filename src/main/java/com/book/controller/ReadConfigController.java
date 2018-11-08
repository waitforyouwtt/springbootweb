package com.book.controller;

import com.book.config.ConfigBean;
import com.book.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 一点点
 * @Date: 2018/11/4 20:31
 * @Version 1.0
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class, User.class})
public class ReadConfigController {
    @Autowired
    ConfigBean configBean;
    @Autowired
    User user;

    @RequestMapping("read-config")
    public String readConfig(){
        return configBean.getGreeting()+":"+configBean.getName()+":"+configBean.getUuid()+":"+configBean.getValue();
    }
    @RequestMapping("user")
    public String user(){
        return user.getName()+":"+user.getAge();
    }


}
