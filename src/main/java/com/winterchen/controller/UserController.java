package com.winterchen.controller;

import com.github.pagehelper.PageHelper;
import com.winterchen.dao.studentMapper;
import com.winterchen.model.Student;
import com.winterchen.model.UserDomain;
import com.winterchen.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Array;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

  @Resource
  private UserService userService;

  @ResponseBody
  @PostMapping("/add")
  public int addUser(UserDomain user) {
    return userService.addUser(user);
  }

  @ResponseBody
  @GetMapping("/all")
  public Object findAllUser(
          @RequestParam(name = "pageNum", required = false, defaultValue = "1")
          int pageNum,
          @RequestParam(name = "pageSize", required = false, defaultValue = "10")
          int pageSize) {
    return userService.findAllUser(pageNum, pageSize);
  }

  //写一个接口，循环运行，插入数据到用户表
  @GetMapping("/for")
  public void forSingle(){
    // 开始时间
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 50000; i++){
      Student student = new Student("李毅" + i,24,"张家界市" + i,i + "号");
      System.out.println(student);
      //对象转数组，打印数组长度
      System.out.println();
      studentMapper.insert(student);
    }
    // 结束时间
    long endTime = System.currentTimeMillis();
    System.out.println("插入数据消耗时间：" + (endTime - startTime));
  }
}
