package com.winterchen.dao;


import com.winterchen.model.UserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserDao {


  /**
   * @param record
   * @return
   */
  int insert(UserDomain record);


  List<UserDomain> selectUsers();

}