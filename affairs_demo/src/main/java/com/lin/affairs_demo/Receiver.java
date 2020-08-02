package com.lin.affairs_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/1
 * \* Time: 19:55
 * \* Description:
 * \
 */

@Slf4j
public class Receiver {

    private CountDownLatch latch;
    @Autowired
    public Receiver( CountDownLatch latch ) {
        this.latch = latch;
    }
    public void receiveMessage( String message ) {
        log.info( "Received <" + message + ">" );
        latch.countDown();
    }


}
