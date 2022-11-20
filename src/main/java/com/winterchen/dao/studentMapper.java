package com.winterchen.dao;

import com.winterchen.model.Student;
import com.winterchen.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 我不是大佬
 */
@Mapper
@Repository

public interface studentMapper {


  Boolean insertStudent(@Param("student") Student student);

//  Boolean insertStudentList(@Param("studentList") List<Student> studentList);

 List<Student> getStudentList();
 Student  getStudent(@Param("name") String name);
 Student getStu(@Param("id") Integer id);

}
