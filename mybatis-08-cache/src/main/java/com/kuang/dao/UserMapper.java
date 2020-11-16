package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/16 17:03
 */
public interface UserMapper {
    // 根据id查询用户
    User queryUsers(@Param("id") int id);
}
