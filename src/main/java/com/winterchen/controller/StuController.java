package com.winterchen.controller;

import com.github.pagehelper.PageInfo;
import com.winterchen.model.AllStudent;
import com.winterchen.service.user.AllStuService;
import com.winterchen.utils.ComResponse;
import com.winterchen.vo.StudentVo;
import org.apache.ibatis.mapping.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <lmx>
 * @since 2022/11/21 16:17
 */
@Controller
@RestController
@RequestMapping
public class StuController<resultMap> {

  private final Logger log = LoggerFactory.getLogger(StuController.class);
  @Resource
  private  AllStuService allStuService;




  @GetMapping("/allStudent")
  @ResponseBody
  public ComResponse findAllStudent(
          @RequestParam(name = "pageNum", required = false, defaultValue = "1")
          Integer pageNum,
          @RequestParam(name = "pageSize", required = false, defaultValue = "10")
          Integer pageSize) {
    Map<String,Object> resultMap=new HashMap<>();
    ComResponse<resultMap> comResponse=new ComResponse<>();
    try{

      PageInfo<AllStudent> byPage=allStuService.findAllStudent(pageNum,pageSize);
      resultMap.put("result",true);
      resultMap.put("page",byPage);
      resultMap.put("AllStudents",byPage.getList());


    }catch (Exception e){
      resultMap.put("result",false);
      resultMap.put("message","分页查询异常");

    }
    comResponse.setData((HashMap) resultMap);
    comResponse.setMsg("查询成功");
    return comResponse;
  }
}
