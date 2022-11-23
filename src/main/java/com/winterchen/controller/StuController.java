package com.winterchen.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.text.DecimalFormat;
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

    return comResponse;
  }

  @GetMapping("/allStudents")
  @ResponseBody
  @Transactional(rollbackFor = Exception.class)
  public ComResponse findAllStudent1(
          @RequestParam(name = "pageNum", required = false, defaultValue = "1")
          Integer pageNum,
          @RequestParam(name = "pageSize", required = false, defaultValue = "20")
          Integer pageSize) {
    long startTime = System.currentTimeMillis();
    ComResponse<List<AllStudent>> comResponse = new ComResponse<>();
    PageInfo<AllStudent> pages = allStuService.findAllStudent(pageNum, pageSize);
    //使用stream拷贝list
    List<AllStuVo> allStuVoList = pages.getList().stream()
            .map(e -> {
              AllStuVo allStuVo = new AllStuVo();
              BeanUtils.copyProperties(e, allStuVo);
              return allStuVo;
            })
            .collect(Collectors.toList());
    comResponse.setData(allStuVoList);
    comResponse.setMsg("查询成功");
    long endTime = System.currentTimeMillis();
    /*DecimalFormat decimalFormat = new DecimalFormat("0.00");
    log.info("查询数据消耗时间: {}s",decimalFormat.format((endTime-startTime)/1000.0));*/
    log.info("查询数据消耗时间: {}s", (endTime - startTime) / 1000.0);
    return comResponse;
  }
}
