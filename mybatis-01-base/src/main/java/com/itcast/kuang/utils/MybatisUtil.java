package com.itcast.kuang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获取 SQLSession 对象
 * @Author: Z.HAN
 * @Date: 2020/11/13 15:27
 */
public class MybatisUtil {
    private static SqlSessionFactory ssf;
    static {
        try {
            // 获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            ssf = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 利用SQLSessionFactory对象获取SQLSession对象
    public static SqlSession getSqlSession() {
        return ssf.openSession();
    }
}
