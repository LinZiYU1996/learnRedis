package com.lin.learnaopblogdemo.common;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/18
 * \* Time: 21:29
 * \* Description:
 * \
 */
public class BaseRequest implements Serializable {

    @NotNull(message = "渠道不能为空！")
    private String channel;


    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "BaseRequest{" +
                "channel='" + channel + '\'' +
                '}';
    }
}
