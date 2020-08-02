package com.lin.publish_subscribe_demo.entity;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/1
 * \* Time: 15:36
 * \* Description:
 * \
 */

@Data
public class RedisPet {

    private String name;
    private String type;

    public RedisPet(String name, String type) {
        super();
        this.name = name;
        this.type = type;
    }



}
