package com.lin.redishyperloglog;

import com.lin.redishyperloglog.annonation.Article;
import com.lin.redishyperloglog.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 21:48
 * \* Description:
 * \
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test {


    @Autowired
    private RedisService redisService;

    @org.junit.Test
    public void t1() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                String name = Thread.currentThread().getName();
                Random r = new Random();
                int begin = r.nextInt(100) * 10000;
                int end = begin + 10000;
                for (int j = begin; j < end; j++) {
                    redisService.pfAdd("hhl:" + name, j + "");
                }
                System.out.printf("线程【%s】完成数据初始化，区间[%d, %d)\n", name, begin, end);
            },
                    i + "");
            thread.start();
        }

    }


    @org.junit.Test
    public void t2() {
        long a = redisService.pfCount("hhl:0");
        long b = redisService.pfCount("hhl:1");
        long c = redisService.pfCount("hhl:2");
        long d = redisService.pfCount("hhl:3");
        long e = redisService.pfCount("hhl:4");
        System.out.printf("hhl:0 -> count: %d, rate: %f\n", a, (10000 - a) * 1.00 / 100);
        System.out.printf("hhl:1 -> count: %d, rate: %f\n", b, (10000 - b) * 1.00 / 100);
        System.out.printf("hhl:2 -> count: %d, rate: %f\n", c, (10000 - c) * 1.00 / 100);
        System.out.printf("hhl:3 -> count: %d, rate: %f\n", d, (10000 - d) * 1.00 / 100);
        System.out.printf("hhl:4 -> count: %d, rate: %f\n", e, (10000 - e) * 1.00 / 100);
    }


    @Article("it")
    public String it(String userId) {
        String pv = redisService.get("PV:it");
        long uv = redisService.pfCount("UV:it");
        return String.format("当前用户：【%s】，当前it类热度：【%s】，访问用户数：【%d】", userId, pv, uv);
    }


    @org.junit.Test
    public void t4(){
        String s = it("0");
        log.info(s);
    }

    @Article("news")
    public String news(String userId) {
        String pv = redisService.get("PV:news");
        long uv = redisService.pfCount("UV:news");
        return String.format("当前用户：【%s】，当前news类热度：【%s】，访问用户数：【%d】", userId, pv, uv);
    }


    @org.junit.Test
    public void t5(){

        String s = news("0");
        log.info(s);
    }


    public Object statistics() {
        String pvIt = redisService.get("PV:it");
        long uvIt = redisService.pfCount("UV:it");

        String pvNews = redisService.get("PV:news");
        long uvNews = redisService.pfCount("UV:news");

        redisService.pfMerge("UV:merge", "UV:it", "UV:news");
        long uvMerge = redisService.pfCount("UV:merge");

        Map<String, String> result = new HashMap<>();
        result.put("it", String.format("it类热度：【%s】，访问用户数：【%d】；", pvIt, uvIt));
        result.put("news", String.format("news类热度：【%s】，访问用户数：【%d】", pvNews, uvNews));
        result.put("merge", String.format("合并后访问用户数：【%d】", uvMerge));
        return result;
    }


    @org.junit.Test
    public void t6(){

        Object o = statistics();

        log.info(o.toString());


    }
}
