package com.winterchen.model;

import lombok.Data;
import lombok.Value;

/**
 * @author <lmx>
 * @since 2022/11/12 21:09
 */
@Data

public class Student {
  /**  主键  type:自增 */

  private int id;

  /**  名字 */
  private String name;

  /**  年龄 */
  private int age;

  /**  地址 */
  private String addr;

  /**  地址号  @TableField：与表字段映射 */

  private String addrNum;

  public Student(String name, int age, String addr, String addrNum) {
    this.name = name;
    this.age = age;
    this.addr = addr;
    this.addrNum = addrNum;
  }
}
