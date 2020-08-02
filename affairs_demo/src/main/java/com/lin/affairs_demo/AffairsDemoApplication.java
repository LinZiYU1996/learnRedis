package com.lin.affairs_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@Slf4j
public class AffairsDemoApplication {
    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
        return container;
    }

    @Bean
    Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    @Bean
    CountDownLatch latch() {
        //测试发送100次消息，所以这里锁为100
        return new CountDownLatch(100);
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx =  SpringApplication.run(AffairsDemoApplication.class, args);
        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);
        log.info("Sending message...");
        long startTime=System.currentTimeMillis();
        for(int i=0;i<100;i++){
            template.convertAndSend( "chat","Hello Redis:"+i );
        }
        latch.await();
        long endTime=System.currentTimeMillis();
        int time = ( int ) (endTime-startTime);
        log.info( "程序运行时间:"+time+"ms" );
        System.exit(0);
    }




//    public static void main(String[] args) {
//        SpringApplication.run(AffairsDemoApplication.class, args);
//    }

    //           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 11ms. Found 0 Redis repository interfaces.
    //2020-08-01 19:57:50.694  INFO 9780 --- [           main] c.l.affairs_demo.AffairsDemoApplication  : Started AffairsDemoApplication in 1.973 seconds (JVM running for 2.908)
    //2020-08-01 19:57:50.694  INFO 9780 --- [           main] c.l.affairs_demo.AffairsDemoApplication  : Sending message...
    //2020-08-01 19:57:50.694  INFO 9780 --- [    container-2] com.lin.affairs_demo.Receiver            : Received <Hello Redis:0>
    //2020-08-01 19:57:50.694  INFO 9780 --- [    container-3] com.lin.affairs_demo.Receiver            : Received <Hello Redis:1>
    //2020-08-01 19:57:50.694  INFO 9780 --- [    container-4] com.lin.affairs_demo.Receiver            : Received <Hello Redis:2>
    //2020-08-01 19:57:50.694  INFO 9780 --- [    container-5] com.lin.affairs_demo.Receiver            : Received <Hello Redis:3>
    //2020-08-01 19:57:50.694  INFO 9780 --- [    container-6] com.lin.affairs_demo.Receiver            : Received <Hello Redis:4>
    //2020-08-01 19:57:50.710  INFO 9780 --- [    container-7] com.lin.affairs_demo.Receiver            : Received <Hello Redis:5>
    //2020-08-01 19:57:50.710  INFO 9780 --- [    container-8] com.lin.affairs_demo.Receiver            : Received <Hello Redis:6>
    //2020-08-01 19:57:50.710  INFO 9780 --- [    container-9] com.lin.affairs_demo.Receiver            : Received <Hello Redis:7>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-10] com.lin.affairs_demo.Receiver            : Received <Hello Redis:8>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-11] com.lin.affairs_demo.Receiver            : Received <Hello Redis:9>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-12] com.lin.affairs_demo.Receiver            : Received <Hello Redis:10>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-13] com.lin.affairs_demo.Receiver            : Received <Hello Redis:11>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-14] com.lin.affairs_demo.Receiver            : Received <Hello Redis:12>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-15] com.lin.affairs_demo.Receiver            : Received <Hello Redis:13>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-16] com.lin.affairs_demo.Receiver            : Received <Hello Redis:14>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-17] com.lin.affairs_demo.Receiver            : Received <Hello Redis:15>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-18] com.lin.affairs_demo.Receiver            : Received <Hello Redis:16>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-19] com.lin.affairs_demo.Receiver            : Received <Hello Redis:17>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-20] com.lin.affairs_demo.Receiver            : Received <Hello Redis:18>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-21] com.lin.affairs_demo.Receiver            : Received <Hello Redis:19>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-22] com.lin.affairs_demo.Receiver            : Received <Hello Redis:20>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-23] com.lin.affairs_demo.Receiver            : Received <Hello Redis:21>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-24] com.lin.affairs_demo.Receiver            : Received <Hello Redis:22>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-25] com.lin.affairs_demo.Receiver            : Received <Hello Redis:23>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-26] com.lin.affairs_demo.Receiver            : Received <Hello Redis:24>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-27] com.lin.affairs_demo.Receiver            : Received <Hello Redis:25>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-28] com.lin.affairs_demo.Receiver            : Received <Hello Redis:26>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-29] com.lin.affairs_demo.Receiver            : Received <Hello Redis:27>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-30] com.lin.affairs_demo.Receiver            : Received <Hello Redis:28>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-31] com.lin.affairs_demo.Receiver            : Received <Hello Redis:29>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-32] com.lin.affairs_demo.Receiver            : Received <Hello Redis:30>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-33] com.lin.affairs_demo.Receiver            : Received <Hello Redis:31>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-34] com.lin.affairs_demo.Receiver            : Received <Hello Redis:32>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-35] com.lin.affairs_demo.Receiver            : Received <Hello Redis:33>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-36] com.lin.affairs_demo.Receiver            : Received <Hello Redis:34>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-37] com.lin.affairs_demo.Receiver            : Received <Hello Redis:35>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-38] com.lin.affairs_demo.Receiver            : Received <Hello Redis:36>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-39] com.lin.affairs_demo.Receiver            : Received <Hello Redis:37>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-40] com.lin.affairs_demo.Receiver            : Received <Hello Redis:38>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-41] com.lin.affairs_demo.Receiver            : Received <Hello Redis:39>
    //2020-08-01 19:57:50.710  INFO 9780 --- [   container-42] com.lin.affairs_demo.Receiver            : Received <Hello Redis:40>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-43] com.lin.affairs_demo.Receiver            : Received <Hello Redis:41>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-44] com.lin.affairs_demo.Receiver            : Received <Hello Redis:42>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-45] com.lin.affairs_demo.Receiver            : Received <Hello Redis:43>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-46] com.lin.affairs_demo.Receiver            : Received <Hello Redis:44>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-47] com.lin.affairs_demo.Receiver            : Received <Hello Redis:45>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-48] com.lin.affairs_demo.Receiver            : Received <Hello Redis:46>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-49] com.lin.affairs_demo.Receiver            : Received <Hello Redis:47>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-50] com.lin.affairs_demo.Receiver            : Received <Hello Redis:48>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-51] com.lin.affairs_demo.Receiver            : Received <Hello Redis:49>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-52] com.lin.affairs_demo.Receiver            : Received <Hello Redis:50>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-53] com.lin.affairs_demo.Receiver            : Received <Hello Redis:51>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-54] com.lin.affairs_demo.Receiver            : Received <Hello Redis:52>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-55] com.lin.affairs_demo.Receiver            : Received <Hello Redis:53>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-56] com.lin.affairs_demo.Receiver            : Received <Hello Redis:54>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-57] com.lin.affairs_demo.Receiver            : Received <Hello Redis:55>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-58] com.lin.affairs_demo.Receiver            : Received <Hello Redis:56>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-59] com.lin.affairs_demo.Receiver            : Received <Hello Redis:57>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-60] com.lin.affairs_demo.Receiver            : Received <Hello Redis:58>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-61] com.lin.affairs_demo.Receiver            : Received <Hello Redis:59>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-62] com.lin.affairs_demo.Receiver            : Received <Hello Redis:60>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-63] com.lin.affairs_demo.Receiver            : Received <Hello Redis:61>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-64] com.lin.affairs_demo.Receiver            : Received <Hello Redis:62>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-65] com.lin.affairs_demo.Receiver            : Received <Hello Redis:63>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-66] com.lin.affairs_demo.Receiver            : Received <Hello Redis:64>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-67] com.lin.affairs_demo.Receiver            : Received <Hello Redis:65>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-68] com.lin.affairs_demo.Receiver            : Received <Hello Redis:66>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-69] com.lin.affairs_demo.Receiver            : Received <Hello Redis:67>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-70] com.lin.affairs_demo.Receiver            : Received <Hello Redis:68>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-71] com.lin.affairs_demo.Receiver            : Received <Hello Redis:69>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-72] com.lin.affairs_demo.Receiver            : Received <Hello Redis:70>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-73] com.lin.affairs_demo.Receiver            : Received <Hello Redis:71>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-74] com.lin.affairs_demo.Receiver            : Received <Hello Redis:72>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-75] com.lin.affairs_demo.Receiver            : Received <Hello Redis:73>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-76] com.lin.affairs_demo.Receiver            : Received <Hello Redis:74>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-77] com.lin.affairs_demo.Receiver            : Received <Hello Redis:75>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-78] com.lin.affairs_demo.Receiver            : Received <Hello Redis:76>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-79] com.lin.affairs_demo.Receiver            : Received <Hello Redis:77>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-80] com.lin.affairs_demo.Receiver            : Received <Hello Redis:78>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-81] com.lin.affairs_demo.Receiver            : Received <Hello Redis:79>
    //2020-08-01 19:57:50.726  INFO 9780 --- [   container-82] com.lin.affairs_demo.Receiver            : Received <Hello Redis:80>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-83] com.lin.affairs_demo.Receiver            : Received <Hello Redis:81>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-84] com.lin.affairs_demo.Receiver            : Received <Hello Redis:82>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-85] com.lin.affairs_demo.Receiver            : Received <Hello Redis:83>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-86] com.lin.affairs_demo.Receiver            : Received <Hello Redis:84>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-87] com.lin.affairs_demo.Receiver            : Received <Hello Redis:85>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-88] com.lin.affairs_demo.Receiver            : Received <Hello Redis:86>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-89] com.lin.affairs_demo.Receiver            : Received <Hello Redis:87>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-90] com.lin.affairs_demo.Receiver            : Received <Hello Redis:88>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-91] com.lin.affairs_demo.Receiver            : Received <Hello Redis:89>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-92] com.lin.affairs_demo.Receiver            : Received <Hello Redis:90>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-93] com.lin.affairs_demo.Receiver            : Received <Hello Redis:91>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-94] com.lin.affairs_demo.Receiver            : Received <Hello Redis:92>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-95] com.lin.affairs_demo.Receiver            : Received <Hello Redis:93>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-96] com.lin.affairs_demo.Receiver            : Received <Hello Redis:94>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-97] com.lin.affairs_demo.Receiver            : Received <Hello Redis:95>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-98] com.lin.affairs_demo.Receiver            : Received <Hello Redis:96>
    //2020-08-01 19:57:50.741  INFO 9780 --- [   container-99] com.lin.affairs_demo.Receiver            : Received <Hello Redis:97>
    //2020-08-01 19:57:50.741  INFO 9780 --- [  container-100] com.lin.affairs_demo.Receiver            : Received <Hello Redis:98>
    //2020-08-01 19:57:50.741  INFO 9780 --- [  container-101] com.lin.affairs_demo.Receiver            : Received <Hello Redis:99>
    //2020-08-01 19:57:50.741  INFO 9780 --- [           main] c.l.affairs_demo.AffairsDemoApplication  : 程序运行时间:47ms

    

}
