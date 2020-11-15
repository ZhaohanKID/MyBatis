package com.itcast.dao;

import com.itcast.domain.User;
import com.itcast.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/14 19:59
 */
public class UserDaoTest {
    @Test
    public void t1() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findUserList();
        for (User user : users) {
            System.out.println(user);
        }
        // 关闭
        sqlSession.close();
    }

    // 测试ById
    @Test
    public void t2() {
        // 获取执行sql的对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserById(2);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("uid", 2);
        map.put("uname", "李四");
        User user = userDao.getUserById2(map);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        /*
        模糊查询传递参数有两种方式：
            一种是在执行Java代码时候传入通配符
            另一种是在sql语句中进行拼接
         */
        // List<User> userList = userDao.getUserList("李");
        /*
            虽然不知道为什么报错了，但是我觉得没错
            但是还有一个sql注入问题。。。好像是在Java代码中传入通配符的方式有这个sql注入问题
         */
        List<User> userList2 = userDao.getUserList("%李%");
        for (User user : userList2) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void t3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 插入在数据库中也是有返回值的，所以这种一般也设置成有返回值的比较好，返回影响的行数
        userDao.insertUser(new User(4, "赵六", "890"));

        // 再查询一下
        List<User> users = userDao.findUserList();
        for (User user : users) {
            System.out.println(user);
        }

        // 注意：增删改必须需要提交事务，虽然我没有提交也对了...
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void t4() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int res = userDao.update(new User(4, "一休", "235"));
        System.out.println(res);

        sqlSession.commit();

        sqlSession.close();
    }

    // 优化的update，万能map
    @Test
    public void test() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "橙光");
        map.put("uid", 4);
        userDao.updateUser(map);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void t5() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int i = userDao.deleteUser(4);
        if (i > 0) {
            System.out.println("删除成功！");
        }
        sqlSession.commit();

        sqlSession.close();
    }
}
