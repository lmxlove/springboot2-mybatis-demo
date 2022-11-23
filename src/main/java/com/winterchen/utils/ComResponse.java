package com.winterchen.utils;

import com.winterchen.model.Student;
import com.winterchen.vo.StudentVo;

import java.util.HashMap;

/**
 * @author <lmx>
 * @since 2022/11/14 21:07
 */
public class ComResponse<T> {

  private int code = 200;
  private String msg = "返回成功";
  private T data;


  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public T getData() {
    return data;
  }

  public void setData(StudentVo data) {
    this.data = (T) data;
  }
  public void setData(Student data) {
    this.data = (T) data;
  }
  public  void setData(HashMap data){
    this.data= (T) data;

  }




}
