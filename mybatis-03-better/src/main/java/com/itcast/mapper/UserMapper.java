package com.itcast.mapper;

import com.itcast.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/14 19:53
 */
public interface UserMapper {
    // 1 获取全部用户
    List<User> findUserList();
    // 2 根据id查询用户
    User getUserById(int id);
    // 3 添加一个用户
    void insertUser(User user);
    // 4 修改一个用户信息
    int update(User user);
    // 5 删除一个用户
    int deleteUser(int id);
}
