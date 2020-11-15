package com.itcast.mapper;

import com.itcast.pojo.User;
import com.itcast.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/14 19:59
 */
public class UserMapperTest {

    // 在哪个类中使用日志，就要有哪个类的反射 .class
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void t1() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
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

        logger.info(sqlSession);
        /*
        可以看到在日志文件中输出以下信息：
[INFO][20-11-15][com.itcast.mapper.UserMapperTest]org.apache.ibatis.session.defaults.DefaultSqlSession@5b8dfcc1
         */

        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = userDao.getUserById(3);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test() {
        logger.info("info:进入了LOG4J");
        logger.debug("debug:进入了LOG4J");
        logger.error("error:进入了LOG4J");
    }

    @Test
    public void t3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        // 插入在数据库中也是有返回值的，所以这种一般也设置成有返回值的比较好，返回影响的行数
        userDao.insertUser(new User(6, "微光", "160"));

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

        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        int res = userDao.update(new User(4, "一休", "235"));
        System.out.println(res);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void t5() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();

        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        int i = userDao.deleteUser(6);
        if (i > 0) {
            System.out.println("删除成功！");
        }
        sqlSession.commit();

        sqlSession.close();
    }
}
