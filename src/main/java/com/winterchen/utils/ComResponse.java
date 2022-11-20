package com.winterchen.utils;

/**
 * @author <lmx>
 * @since 2022/11/14 21:07
 */
public class ComResponse<T> {
  private String msg = "返回成功";
  private int code = 200;
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

  public void setData(T data) {
    this.data = data;
  }

}
