package com.winterchen.service.user.impl;

import com.winterchen.dao.UserMapper;
import com.winterchen.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <lmx>
 * @since 2022/11/14 13:54
 */
@Service(value = "UserMapper")
public class UserMapperImpl implements UserMapper {
  /**
   * @return
   */
  @Override
  public List<User> listUser() {
    return null;
  }

  /**
   * @param user
   * @return
   */
  @Override
  public Boolean insertUser(User user) {
    return null;
  }

  /**
   * @param userList
   * @return
   */
  @Override
  public Boolean insertUserList(List<User> userList) {
    return null;
  }
}
