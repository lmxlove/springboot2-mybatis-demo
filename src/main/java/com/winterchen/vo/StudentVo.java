package com.winterchen.vo;


import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * @author <lmx>
 * @since 2022/11/20 19:56
 */


public class StudentVo implements Serializable {



  private static final Long serialVersionUID=2L;


  private String addr;

  public StudentVo(String addr) {
    this.addr = addr;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  @Override
  public String toString() {
    return "StudentVo{" +
            "addr=" + addr +
            '}';
  }
}
