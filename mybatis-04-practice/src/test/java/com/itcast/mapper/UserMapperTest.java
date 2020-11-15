package com.itcast.mapper;

import com.itcast.pojo.User;
import com.itcast.utils.SqlSessionUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/14 19:59
 */
public class UserMapperTest {

    // 在哪个类中使用日志，就要有哪个类的反射 .class
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    // 测试ById
    @Test
    public void t1() {
        // 获取执行sql的对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        logger.info(sqlSession);

        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = userDao.getUserById(3);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void t2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void t3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();


        // 使用RowBound实现分页查询
        RowBounds rowBounds = new RowBounds(1, 2);
        List<User> list = sqlSession.selectList("com.itcast.mapper.UserMapper.getUserByLimit", null, rowBounds);
        for (User user : list) {
            System.out.println(user);
        }


        sqlSession.close();
    }

    @Test
    public void test() {
        logger.info("info:进入了LOG4J");
        logger.debug("debug:进入了LOG4J");
        logger.error("error:进入了LOG4J");
    }

}
