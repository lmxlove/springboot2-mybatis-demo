package com.winterchen.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zongshaofeng
 * @Description:
 * @Date:Create：in 2021/9/12 11:52
 * @Modified By：
 */
@Data
public class User implements Serializable {

  private Integer id;
  private Date time;
  private String name;
  private String content;

  public User(Date time, String name, String content) {

    this.time = time;
    this.name = name;
    this.content = content;
  }


  public User() {

  }
}
