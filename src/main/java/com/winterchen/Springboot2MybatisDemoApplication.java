package com.winterchen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 我不是大佬
 */
@SpringBootApplication
@MapperScan("com.winterchen.dao")

public class Springboot2MybatisDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot2MybatisDemoApplication.class, args);
  }
}
