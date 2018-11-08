package com.book.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 一点点
 * @Date: 2018/11/6 23:29
 * @Version 1.0
 */
@Controller
public class HelloController {

    @ApiOperation(value = "nihao")
    @RequestMapping("/hello")
    public String hello(){
       return  "nihao";
    }

}
