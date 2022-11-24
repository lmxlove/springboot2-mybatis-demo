package com.winterchen.vo;

import cn.hutool.core.date.DateTime;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author <lmx>
 * @since 2022/11/21 16:22
 */

@Data
public class AllStuVo implements Serializable {
  private static final Long serialVersionUID = 4L;
  public   Long student_id;
  public   String name;
  public   String tel;
  public   String address;
  public Date birthday;


//  public AllStuVo(Long student_id, String name, String tel, String address, Date birthday ) {
//    this.student_id = student_id;
//    this.name = name;
//    this.tel = tel;
//    this.address = address;
//    this.birthday = birthday;
//
//  }


  @Override
  public String toString() {
    return "AllStuVo{" +
            "student_id=" + student_id +
            ", name='" + name + '\'' +
            ", tel='" + tel + '\'' +
            ", address='" + address + '\'' +
            ", birthday=" + birthday ;
  }
}
