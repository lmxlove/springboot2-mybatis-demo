package com.winterchen.dao;

import com.winterchen.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zongshaofeng
 * @Description:
 * @Date:Create：in 2021/9/12 11:55
 * @Modified By：
 */
@Mapper
@Repository
public interface UserMapper {
  List<User> listUser();

   Boolean insertUser(@Param("user") User user);

  Boolean insertUserList(@Param("userList") List<User> userList);

}
