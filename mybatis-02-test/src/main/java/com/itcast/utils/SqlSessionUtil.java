package com.itcast.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/14 19:41
 */
public class SqlSessionUtil {
    private static SqlSessionFactory ssf;
    // 加载配置文件，里面应该写上关于数据库连接的配置
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            ssf = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static SqlSession getSqlSession() {
        return ssf.openSession();
    }
}
