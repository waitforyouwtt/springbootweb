package com.book.service;

import com.book.dao.UserInfoDao;
import com.book.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: 一点点
 * @Date: 2018/11/6 22:56
 * @Version 1.0
 */
@Service
public class UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfo findUserByName(String userName){
       return userInfoDao.findUserInfoByUsername(userName);
    }

    public List<UserInfo> findAll(){
        return userInfoDao.findAll();
    }

    public UserInfo save(UserInfo userInfo){
        return userInfoDao.save(userInfo);
    }
    public Optional<UserInfo> findUserInfoById(long id){
        return userInfoDao.findById(id);
    }
    public UserInfo updateUser(UserInfo userInfo){
        return userInfoDao.saveAndFlush(userInfo);
    }
    public void deleteUser(UserInfo userInfo){
        userInfoDao.delete(userInfo);
    }

}
