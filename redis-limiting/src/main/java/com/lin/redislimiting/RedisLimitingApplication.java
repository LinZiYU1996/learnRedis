package com.lin.redislimiting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisLimitingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisLimitingApplication.class, args);
    }

}
