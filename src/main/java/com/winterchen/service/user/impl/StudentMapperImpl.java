package com.winterchen.service.user.impl;

import com.winterchen.dao.studentMapper;
import com.winterchen.model.Student;
import com.winterchen.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author <lmx>
 * @since 2022/11/14 19:43
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StudentMapperImpl implements studentMapper {
  @Resource
  private  studentMapper studentMapper;
  /**
   * @param student
   * @return
   */


  /**
   * @param student
   * @return
   */
  @Override
  public Boolean insertStudent(Student student) {
    return null;
  }

  /**
   * @return
   */
  @Override
  public List<Student> getStudentList() {
    return studentMapper.getStudentList();
  }

  /**
   * @param name
   * @return
   */
  @Override
  public Student getStudent(String name) {
    return studentMapper.getStudent(name);
  }

  /**
   * @param id
   * @return
   */
  @Override
  public Student getStu(Integer id) {
    return studentMapper.getStu(id);
  }

  /**
   * @param studentList
   * @return
   */


  /**
   * @param
   * @return
   */
//  @Override
//  public Boolean insertStudentList(List<Student> studentList) {
//    return null;
//  }
}
