package com.zjj.exercise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//spring boot启动类的注解
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//整合mybatis时  指定需要扫描的mapper接口
@MapperScan("com.zjj.exercise.dao")
//自定义过滤器Filter生效
@ServletComponentScan
//定时任务的注解
//@EnableScheduling
//异步调用注解
@EnableAsync
public class ExerciseApplication {


    public static void main(String[] args) {
        SpringApplication.run(ExerciseApplication.class, args);
    }
}
