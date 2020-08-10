package com.lin.redisdistributedlock2;

import com.lin.redisdistributedlock2.service.LockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.Thread.sleep;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 15:41
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisLockService {

    public static final Logger logger = LoggerFactory.getLogger(TestRedisLockService.class);

    static int i = 0;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    LockService lockService;

    private String lockKey = "lock";

    @Test
    public void redisLock() throws InterruptedException {
        while (i++ < 10) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lockService.redisLock(i);
                }
            }).start();
        }

        sleep(100 * 6 * 2);
    }


}
