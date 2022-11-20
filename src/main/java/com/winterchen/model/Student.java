package com.winterchen.model;

import lombok.Data;

import java.io.Serializable;


public class Student implements Serializable {


  private static final Long serialVersionUID=1L;

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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public String getAddr_num() {
    return addr_num;
  }

  public void setAddr_num(String addr_num) {
    this.addr_num = addr_num;
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
