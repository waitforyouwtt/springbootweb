package com.book.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: 一点点
 * @Date: 2018/11/4 21:17
 * @Version 1.0
 */
@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String username;
    @Column
    private String password;
}
