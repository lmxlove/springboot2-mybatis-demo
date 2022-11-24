package com.winterchen;
import com.winterchen.model.User;
import com.winterchen.service.user.impl.UserMapperImpl;
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
//  @Resource
//  private UserMapper userMapper;
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
        //1.必须先注入mapper，才能调用它的方法，
        //实现原理，mybatis的反射加动态代理，所以不用实现类
        //2.或者搞个实现类，new实例化一下或者反射，再调用接口里面的方法，
        //3.或者增加一个类，接口作为成员变量，传入这个类的构造函数中，
        //将这个接口实现类传入增加的那个类的构造函数中也可以实现，增加的那个类也要实例化或者反射
        UserMapperImpl userMapperImpl=new UserMapperImpl();
        userMapperImpl.insertUser(user);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    System.out.println("***********************for循环单条写入总共用时："+ ChronoUnit.MILLIS.between(start,Instant.now()) +"毫秒***********************************");
  }
}
