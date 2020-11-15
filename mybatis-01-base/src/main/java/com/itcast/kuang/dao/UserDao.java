package com.itcast.kuang.dao;

import com.itcast.kuang.domain.User;

import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/13 15:48
 */
public interface UserDao {
    List<User> getUserList();
}
