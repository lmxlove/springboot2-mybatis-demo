package com.winterchen.dao;

import com.winterchen.model.AllStudent;
import com.winterchen.vo.AllStuVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface AllStuMapper {


  List<AllStudent> selectStudents();
}
