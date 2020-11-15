package com.itcast.mapper;

import com.itcast.pojo.Teacher;
import com.itcast.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/15 17:58
            */
    public class TeacherMapperTest {
        @Test
        public void test1() {
            SqlSession sqlSession = SqlSessionUtil.getSqlSession();

            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = teacherMapper.getTeacher(1);
            System.out.println(teacher);

            sqlSession.close();
        }
}
