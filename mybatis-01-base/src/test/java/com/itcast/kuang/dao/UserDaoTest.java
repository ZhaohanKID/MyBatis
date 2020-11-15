package com.itcast.kuang.dao;

import com.itcast.kuang.domain.User;
import com.itcast.kuang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/13 16:03
 */
public class UserDaoTest {
    @Test
    public void test1() {
        // 1 获取SqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        // 2 获取UserDao对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        // 3 关闭SQLSession
        sqlSession.close();
    }
}
