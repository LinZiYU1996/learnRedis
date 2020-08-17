package com.lin.learnaop;

import com.lin.learnaop.demo_2.MyAspect;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.lin.learnaop.demo_3.mapper")
public class LearnAopApplication {

    @Bean(name="myAspect")
    public MyAspect init() {
        return new MyAspect();
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnAopApplication.class, args);
    }

}
