package com.winterchen.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <lmx>
 * @since 2022/11/21 16:22
 */
public class AllStuVo implements Serializable {
  private static final Long serialVersionUID = 4L;
  private  Long student_id;
  private  String name;
  private  String tel;
  private  String address;
  private Date birthday;
  private Date create_time;

  @Override
  public String toString() {
    return "AllStuVo{" +
            "student_id=" + student_id +
            ", name='" + name + '\'' +
            ", tel='" + tel + '\'' +
            ", address='" + address + '\'' +
            ", birthday=" + birthday +
            ", create_time=" + create_time +
            '}';
  }
}
