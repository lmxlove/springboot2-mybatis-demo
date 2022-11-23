package com.winterchen.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.AllStuMapper;
import com.winterchen.model.AllStudent;
import com.winterchen.service.user.AllStuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author <lmx>
 * @since 2022/11/21 16:21
 */
@Service(value="AllStuService")
public class AllStuMapperImpl implements AllStuService {

  @Resource
  private  AllStuMapper allStuMapper;

  /**
   * @param pageNum
   * @param pageSize
   * @return
   */


  /**
   * @param pageNum
   * @param pageSize
   * @return
   */
  @Override
  public PageInfo<AllStudent> findAllStudent(Integer pageNum, Integer pageSize){
    //将参数传给这个方法就可以实现物理分页了，非常简单。
    PageHelper.startPage(pageNum, pageSize);
    List<AllStudent> allStudents = allStuMapper.selectStudents();
    return new PageInfo<>(allStudents);

  }
}
