package com.winterchen.dao;


import com.winterchen.model.UserDomain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author 我不是大佬
 */
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