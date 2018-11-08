package com.book.controller;

import com.book.entity.UserInfo;
import com.book.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

/**
 * @Author: 一点点
 * @Date: 2018/11/4 20:04
 * @Version 1.0
 */
@RequestMapping("/user")
@RestController
public class IndexController {
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private Integer age;
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/index")
    public String index(){
        return "this is index";
    }
    @RequestMapping("/value")
    public String getValue(){
        return name + ":"+age;
    }

    @GetMapping("/{username}")
    public UserInfo getUser(@PathVariable("username")String username){
        return userInfoService.findUserByName(username);
    }
    @ApiOperation(value = "用户列表",notes = "用户列表")
    @GetMapping("/getusers")
    public List<UserInfo> getUsers(){
        return userInfoService.findAll();
    }

    @ApiOperation(value = "创建用户",notes = "创建用户")
    @PostMapping("/save")
    public UserInfo postUser(@RequestBody UserInfo userInfo){
        return userInfoService.save(userInfo);
    }
    @ApiOperation(value = "获取用户信息",notes = "获取用户信息")
    @GetMapping("/{id}")
    public Optional<UserInfo> getUserInfo(@PathVariable Long id){
        return userInfoService.findUserInfoById(id);
    }
    @ApiOperation(value = "更新信息",notes = "根据url的id来指定更新用户信息")
    @PostMapping("/{id}")
    public UserInfo putUser(@PathVariable Long id,@RequestBody UserInfo userInfo){
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUsername(userInfo.getUsername());
        userInfo1.setPassword(userInfo.getPassword());
        userInfo1.setId(userInfo.getId());
        return userInfoService.updateUser(userInfo1);
    }
    @ApiOperation(value = "删除用户",notes = "根据url的id来指定删除用户信息")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfoService.deleteUser(userInfo);
    }
    //使用该注解忽略这个API
    @ApiIgnore
    @GetMapping("/hi")
    public String json(){
        return "hi you";
    }


}
