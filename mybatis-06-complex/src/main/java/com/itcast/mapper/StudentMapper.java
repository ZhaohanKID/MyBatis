package com.itcast.mapper;

import com.itcast.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/15 16:04
 */
public interface StudentMapper {
    // 查询所有学生信息，以及对应的老师的信息
//    @Select("select * from student")
    List<Student> getStudent();

    List<Student> getStudent2();

}
