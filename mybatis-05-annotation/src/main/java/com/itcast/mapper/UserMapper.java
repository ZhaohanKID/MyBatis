package com.itcast.mapper;


import com.itcast.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/14 19:53
 */
public interface UserMapper {
    @Select("select * from `user`")
    List<User> getUsers();

    // 注：这里使用了@Param注解，也就是#{id}取得值一定要与@Param("id")里面传入的值相同
    @Select("select * from `user` where id = #{id}")
    User getUserById(@Param("id") int uid);

    @Insert("insert into `user`(id, username, password) values(#{id}, #{username}, #{password})")
    void addUser(User user);
}
