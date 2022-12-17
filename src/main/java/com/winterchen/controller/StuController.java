package com.winterchen.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.AllStuMapper;
import com.winterchen.model.AllStudent;
import com.winterchen.service.user.AllStuService;
import com.winterchen.utils.ComResponse;
import com.winterchen.vo.AllStuVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <lmx>
 * @since 2022/11/21 16:17
 */
@Controller
@RestController
@RequestMapping
public class StuController {

  private final Logger log = LoggerFactory.getLogger(StuController.class);
  @Resource
  private AllStuService allStuService;
  @Resource
  private  AllStuMapper allStuMapper;


  @GetMapping("/allStudent")
  @ResponseBody
  public <resultMap> ComResponse findAllStudent(
          @RequestParam(name = "pageNum", required = false, defaultValue = "1")
          Integer pageNum,
          @RequestParam(name = "pageSize", required = false, defaultValue = "10")
          Integer pageSize) {
    long startTime = System.currentTimeMillis();
    Map<String, Object> resultMap = new HashMap<>(16);
    ComResponse<resultMap> comResponse = new ComResponse<>();
    try {

      PageInfo<AllStudent> byPage = allStuService.findAllStudent(pageNum, pageSize);
      resultMap.put("result", true);
      resultMap.put("page", byPage);
      resultMap.put("AllStudentsList", byPage.getList());


    } catch (Exception e) {
      resultMap.put("result", false);
      resultMap.put("message", "分页查询异常");

    } finally {
      PageHelper.clearPage();
    }
    comResponse.setData((HashMap) resultMap);
    comResponse.setMsg("查询成功");
    long endTime = System.currentTimeMillis();
   /* DecimalFormat decimalFormat = new DecimalFormat("0.00");
    log.info("查询数据消耗时间: {}s",decimalFormat.format((endTime-startTime)/1000.0));*/
    log.info("查询数据消耗时间: {}s", (endTime - startTime) / 1000.0);
    allStuService=null;

    return comResponse;
  }

  @GetMapping("/allStudents")
  @ResponseBody
  @Transactional(rollbackFor = Exception.class)
  @CrossOrigin
  public <resultMap> ComResponse findAllStudent1(
          @RequestParam(name = "pageNum", required = false, defaultValue = "1")
          Integer pageNum,
          @RequestParam(name = "pageSize", required = false, defaultValue = "200")
          Integer pageSize) {
    long startTime = System.currentTimeMillis();
    Map<String, Object> resultMap = new HashMap<>(16);
    ComResponse<resultMap> comResponse = new ComResponse<>();
    try{
      //PageInfo<AllStudent> pages = allStuService.findAllStudent(pageNum, pageSize);
      //开启分页
      PageHelper.startPage(pageNum,pageSize);
      //从数据库中查询出
      List studentDos= allStuMapper.selectStudents();
      //获取分页信息
      PageInfo studentDoPageInfo=new PageInfo<>(studentDos);
      //创建需要分页的voList
      //List studentVos=new ArrayList<>();
      //对象转换
      //      for(Object studentDo:studentDos){
      //        AllStuVo allStuVo=new AllStuVo();
      //        BeanUtils.copyProperties(studentDo,allStuVo);
      //        studentVos.add(allStuVo);
      //      }
      //对象转换
     List studentVos= (List) studentDos.stream().map(e->{
        AllStuVo allStuVo=new AllStuVo();
        BeanUtils.copyProperties(e,allStuVo);
        return allStuVo;
      }).collect(Collectors.toList());
      //将封装后的列表放到分页对象中
      studentDoPageInfo.setList(studentVos);
      //使用stream拷贝list
      List<AllStuVo> allStuVoList = (List<AllStuVo>) studentDoPageInfo.getList().stream().map(e -> {
                AllStuVo allStuVo = new AllStuVo();
                BeanUtils.copyProperties(e, allStuVo);
                return allStuVo;
              }).collect(Collectors.toList());
      resultMap.put("result",true);
      resultMap.put("AllStudentVoList",allStuVoList);
      resultMap.put("pages",studentDoPageInfo);

    }catch (Exception e){
      resultMap.put("result",false);
      resultMap.put("message","分页异常，请重试");

    }finally {
      PageHelper.clearPage();
    }
    comResponse.setData((HashMap) resultMap);
    comResponse.setMsg("查询成功");
    long endTime = System.currentTimeMillis();
    /*DecimalFormat decimalFormat = new DecimalFormat("0.00");
    log.info("查询数据消耗时间: {}s",decimalFormat.format((endTime-startTime)/1000.0));*/
    log.info("查询数据消耗时间: {}s", (endTime - startTime) / 1000.0);
    return comResponse;
  }

  @GetMapping("/allStu")
  @ResponseBody
  @Transactional(rollbackFor = Exception.class)
  public PageInfo getAllStudent(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                  Integer pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "100")
                                 Integer pageSize ) {
    long startTime = System.currentTimeMillis();
    PageInfo studentDoPageInfo = null;
    try {
      PageHelper.startPage(pageNum, pageSize);
      List<AllStudent> studentDos = allStuMapper.selectStudents();
      studentDoPageInfo = new PageInfo<>(studentDos);
      List studentVos = new ArrayList<>();
      for (Object studentDo : studentDos) {
        AllStuVo allStuVo = new AllStuVo();
        BeanUtils.copyProperties(studentDo, allStuVo);
        studentVos.add(allStuVo);
      }
      studentDoPageInfo.setList(studentVos);
    } catch (Exception e) {
      //异常捕获
    } finally {
      PageHelper.clearPage();
    }

    long endTime = System.currentTimeMillis();
    log.info("查询数据消耗时间: {}s", (endTime - startTime) / 1000.0);
    return studentDoPageInfo;
  }
}
