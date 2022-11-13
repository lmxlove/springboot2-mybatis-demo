package com.winterchen;

import com.winterchen.dao.UserMapper;
import com.winterchen.model.User;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author <lmx>
 * @since 2022/11/12 23:31
 */

@MapperScan("com.winterchen.dao")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot2MybatisDemoApplication.class)
public class forTest {
  @Resource
  private UserMapper userMapper;
  @Test
  public void insertForUser() {
    Instant start= Instant.now();
    try {
      int count = 100;
      for (int i = 0; i < count; i++) {
        User user = new User();
        user.setId(i);
        user.setTime(new Date());
        user.setName("单条插入"+i);
        user.setContent(String.valueOf(i));
        System.out.println(user);
        //必须先注入mapper，才能调用它的方法
        //怎么查看数据库的表有多大
        userMapper.insertUser(user);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    System.out.println("***********************for循环单条写入总共用时："+ ChronoUnit.MILLIS.between(start,Instant.now()) +"毫秒***********************************");
  }
}
