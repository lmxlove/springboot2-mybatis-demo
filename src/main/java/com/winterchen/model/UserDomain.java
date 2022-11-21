package com.winterchen.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author 我不是大佬
 */
@Data
public class UserDomain implements Serializable {
  private Integer userId;

  private String userName;

  private String password;

  private String phone;

  public static void insertUser(UserDomain user) {
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserName(String 单条插入) {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName == null ? null : userName.trim();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  public String getPhone() {
    return phone;
  }


  public void setPhone(String phone) {
    this.phone = phone == null ? null : phone.trim();
  }


}