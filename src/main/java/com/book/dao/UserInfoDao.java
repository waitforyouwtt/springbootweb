package com.book.dao;

import com.book.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 一点点
 * @Date: 2018/11/6 22:55
 * @Version 1.0
 */
public interface UserInfoDao extends JpaRepository<UserInfo,Long>{

    UserInfo findUserInfoByUsername(String username);
}
