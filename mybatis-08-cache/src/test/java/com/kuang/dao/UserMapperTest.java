package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/16 17:12
 */
public class UserMapperTest {
    @Test
    public void queryUsers() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUsers(3);
        System.out.println(user);

        System.out.println("----------------------------");

        // 如果在这中间手动清理掉缓存，则不相等了
        sqlSession.clearCache();

        // 再次查询同一个用户，有缓存的存在(mybatis默认开启一级缓存)，则只查询一次数据库
        User user2 = mapper.queryUsers(3);
        System.out.println(user);
        System.out.println(user == user2);

        sqlSession.close();
    }
}
