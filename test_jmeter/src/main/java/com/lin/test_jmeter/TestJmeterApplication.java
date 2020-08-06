package com.lin.test_jmeter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.test_jmeter.mapper")
public class TestJmeterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestJmeterApplication.class, args);
    }

}
