package com.winterchen.controller;

import com.sun.org.apache.xerces.internal.impl.xs.util.StringListImpl;
import com.winterchen.dao.studentMapper;
import com.winterchen.model.Student;
import com.winterchen.model.UserDomain;
import com.winterchen.service.user.UserService;
import com.winterchen.service.user.impl.StudentMapperImpl;
import com.winterchen.utils.ComResponse;
import com.winterchen.vo.StudentVo;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.Object;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RestController
@RequestMapping(value = "/user")
public class UserController {
  private final Logger log = LoggerFactory.getLogger(UserController.class);

  @Resource
  private UserService userService;
  @Resource
  private  studentMapper studentMapper;

  @Resource
  private  StudentMapperImpl studentMapperImpl;

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
    return (Object) userService.findAllUser(pageNum, pageSize);
  }

  //写一个接口，循环运行，插入数据到用户表
  @GetMapping("/for")
  @ResponseBody
  public String forSingle(){
    // 开始时间
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 10000000; i++){
      Student student = new Student("李毅" + i,24,"张家界市" + i,i + "号");
      studentMapper.insertStudent(student);
    }
    // 结束时间
    long endTime = System.currentTimeMillis();
    System.out.println("插入数据消耗时间：" + (endTime - startTime));
    String a="插入成功";
    return a;
  }
  @GetMapping("/getStudentInfo")
  @ResponseBody
  public ComResponse getStudentInfo(){
    long startTime = System.currentTimeMillis();
    ComResponse<List<Student>> objComResponse=new ComResponse<>();
    List<Student> studentList= studentMapperImpl.getStudentList();
    objComResponse.setData((StudentVo) studentList);
    objComResponse.setMsg("返回成功");
    long endTime = System.currentTimeMillis();
    System.out.println("查询数据消耗时间：" + (endTime - startTime));
    return objComResponse;
  }

  @GetMapping("/getStudent/{name}")
  @ResponseBody
  public  ComResponse getStudent(@PathVariable("name") @RequestBody String  name){
    long startTime = System.currentTimeMillis();
    ComResponse<Student> Object=new ComResponse<>();

    Student student=studentMapperImpl.getStudent(name);
    StudentVo studentVo=new StudentVo();
    BeanUtils.copyProperties(student,studentVo);
    log.info("拷贝前的数据是: {}",student);
    log.info("拷贝后的数据是: {}",studentVo);
    Object.setData(studentVo);
    Object.setMsg("返回成功");
    long endTime = System.currentTimeMillis();
    DecimalFormat decimalFormat=new DecimalFormat("0.00");
    //log.info("查询数据消耗时间: {}s",decimalFormat.format((endTime-startTime)/1000.0));
    log.info("查询数据消耗时间: {}s",(endTime-startTime)/1000.0);
    return Object;

  }
  @GetMapping("/getStu/{id}")
  @ResponseBody
  private  ComResponse getStu(@PathVariable("id") @RequestBody Integer id){
    long startTime=System.currentTimeMillis();
    ComResponse<Student> studentComResponse=new ComResponse<>();
    Student student=studentMapperImpl.getStu(id);
    studentComResponse.setData(student);
    studentComResponse.setMsg("返回成功");
    long endTime=System.currentTimeMillis();
    //控制台打印日志自带锁，不推荐使用
    //System.out.println("查询数据消耗时间"+(endTime-startTime));
    log.info("查询数据消耗时间: {}ms",endTime-startTime);
    return studentComResponse;

  }


}
