package com.lin.learnzookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/19
 * \* Time: 10:16
 * \* Description:
 * \
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test {



    @Autowired
    private ZkApi zkApi;

    @org.junit.Test
    public void t1() {


        zkApi.createNode("/abc","abc");

    }


    @org.junit.Test
    public void t2() throws KeeperException, InterruptedException {

        log.info(zkApi.getChildren("/abc").toString());


    }

    @org.junit.Test
    public void t3() {

        log.info(zkApi.getData("/abc", new WatcherApi()));

        //2020-08-19 10:39:32.913  INFO 26564 --- [           main] com.lin.learnzookeeper.Test              : abc

    }



    @org.junit.Test
    public void t4() {

        log.info(zkApi.exists("/abc", new WatcherApi()).toString());

        //2020-08-19 10:40:32.519  INFO 56044 --- [           main] com.lin.learnzookeeper.Test              : 75,75,1597804359175,1597804359175,0,0,0,0,3,0,75


    }

}
