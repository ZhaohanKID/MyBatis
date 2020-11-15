package com.itcast.mapper;


import com.itcast.pojo.User;
import com.itcast.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/14 19:59
 */
public class UserMapperTest {
    @Test
    public void t1() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        // 底层主要使用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUsers();
        for (User user : list) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void t2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(7, "阿尔卑斯", "341"));

        sqlSession.close();
    }
}
