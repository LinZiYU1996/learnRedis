package com.lin.redisblogarticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class RedisBlogArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisBlogArticleApplication.class, args);
    }

}
