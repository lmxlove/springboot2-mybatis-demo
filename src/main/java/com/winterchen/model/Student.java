package com.winterchen.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author <lmx>
 * @since 2022/11/12 21:09
 */
@Data
public class Student implements Serializable {
  /**  主键  type:自增 */

  private int id;

  /**  名字 */
  private String name;

  /**  年龄 */
  private int age;

  /**  地址 */
  private String addr;

  /**  地址号  @TableField：与表字段映射 */

  private String addr_num;

  public Student(String name, int age, String addr, String addr_num) {
    this.name = name;
    this.age = age;
    this.addr = addr;
    this.addr_num = addr_num;
  }
  public  Student(){

  }

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", addr='" + addr + '\'' +
            ", addr_num='" + addr_num + '\'' +
            '}';
  }
}
