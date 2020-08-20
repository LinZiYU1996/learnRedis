package com.lin.learnzookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/19
 * \* Time: 10:11
 * \* Description:
 * \
 */
public class WatcherApi implements Watcher {

    private static final Logger logger = LoggerFactory.getLogger(WatcherApi.class);
    @Override
    public void process(WatchedEvent event) {
        logger.info("【Watcher监听事件】={}",event.getState());
        logger.info("【监听路径为】={}",event.getPath());
        logger.info("【监听的类型为】={}",event.getType()); //  三种监听类型： 创建，删除，更新
    }
}


