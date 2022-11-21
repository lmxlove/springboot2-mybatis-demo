package com.winterchen.dao;

import com.winterchen.model.AllStudent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface AllStuMapper {


  List<AllStudent> selectStudents();
}
