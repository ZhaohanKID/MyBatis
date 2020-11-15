package com.itcast.mapper;

import com.itcast.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/14 19:53
 */
public interface UserMapper {
    // 2 根据id查询用户
    User getUserById(int id);

    /*
        忽然知道什么时候应该使用Map了，当需要传入多个参数的时候就需要使用map
     */
    // 分页查询
    List<User> getUserByLimit(Map<String, Integer> map);
}
