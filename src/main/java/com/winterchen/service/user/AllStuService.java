package com.winterchen.service.user;

import com.github.pagehelper.PageInfo;
import com.winterchen.model.AllStudent;
import com.winterchen.model.UserDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 我不是大佬
 */
public interface AllStuService {
  PageInfo<AllStudent> findAllStudent(Integer pageNum, Integer pageSize);


}
