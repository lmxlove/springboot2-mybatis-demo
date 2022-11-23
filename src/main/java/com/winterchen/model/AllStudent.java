package com.winterchen.model;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <lmx>
 * @since 2022/11/21 16:19
 */
@Data
public class AllStudent implements Serializable {
  private static final Long serialVersionUID=3L;

  private  Long student_id;
  private  String name;
  private  String tel;
  private  String address;
  private Date birthday;
  private Date create_time;
  private Date update_time;

  public AllStudent(Long student_id, String name, String tel, String address, DateTime birthday, DateTime create_time, DateTime update_time) {
    this.student_id=student_id;
    this.name = name;
    this.tel = tel;
    this.address = address;
    this.birthday = birthday;
    this.create_time = create_time;
    this.update_time = update_time;
  }
  public  AllStudent(){

  }
}
