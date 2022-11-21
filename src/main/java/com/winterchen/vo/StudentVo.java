package com.winterchen.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author <lmx>
 * @since 2022/11/20 19:56
 */

@Data
public class StudentVo implements Serializable {


  private static final Long serialVersionUID = 2L;

  private int age;
  private String addr;
  private String addr_num;


  @Override
  public String toString() {
    return "StudentVo{" +
            "age=" + age +
            ", addr='" + addr + '\'' +
            ", addr_num='" + addr_num + '\'' +
            '}';
  }
}
