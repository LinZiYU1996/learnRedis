package com.lin.redisblogarticle.aop;

import com.lin.redisblogarticle.utils.IpUtils;
import com.lin.redisblogarticle.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/12
 * \* Time: 16:46
 * \* Description:
 * \
 */
@Aspect
@Configuration
@Slf4j
public class PageViewAspect {

    @Autowired
    private RedisUtils redisUtil;

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.lin.redisblogarticle.annotation.PageView)")
    public void PageViewAspect() {

    }

    /**
     * 切入处理
     * @param joinPoint
     * @return
     */
    @Around("PageViewAspect()")
    public  Object around(ProceedingJoinPoint joinPoint) {
        Object[] object = joinPoint.getArgs();
        Object articleId = object[0];
        log.info("articleId:{}", articleId);
        Object obj = null;
        try {
            String ipAddr = IpUtils.getIpAddr();
            log.info("ipAddr:{}", ipAddr);
            String key = "articleId_" + articleId;
            // 浏览量存入redis中
            Long num = redisUtil.add(key,ipAddr);
            if (num == 0) {
                log.info("该ip:{},访问的浏览量已经新增过了", ipAddr);
            }
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return obj;
    }
}