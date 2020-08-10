package com.lin.redisdistributedlock.distributed.interceptor;

import com.lin.redisdistributedlock.distributed.annotation.CacheLock;
import com.lin.redisdistributedlock.distributed.common.CacheKeyGenerator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 9:42
 * \* Description:
 * \
 */
@Aspect
@Configuration
public class LockMethodInterceptor {

    @Autowired
    public LockMethodInterceptor(StringRedisTemplate lockRedisTemplate, CacheKeyGenerator cacheKeyGenerator) {
        this.lockRedisTemplate = lockRedisTemplate;
        this.cacheKeyGenerator = cacheKeyGenerator;
    }

//    public LockMethodInterceptor(){}

    private final StringRedisTemplate lockRedisTemplate;
    private final CacheKeyGenerator cacheKeyGenerator;


    @Around("execution(public * *(..)) && @annotation(com.lin.redisdistributedlock.distributed.annotation.CacheLock)")
    public Object interceptor(ProceedingJoinPoint pjp) {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        CacheLock lock = method.getAnnotation(CacheLock.class);

        if (StringUtils.isEmpty(lock.prefix())) {
            throw new RuntimeException("lock key can't be null...");
        }
        final String lockKey = cacheKeyGenerator.getLockKey(pjp);
        final long lockTime = lock.expire();
        try {
            //key不存在才能设置成功，获得了分布式锁，设置锁过期时间
            final Boolean success = lockRedisTemplate.opsForValue().setIfAbsent(lockKey, String.valueOf(System.currentTimeMillis()+lockTime));
            if (success) {
                lockRedisTemplate.expire(lockKey, lock.expire(), lock.timeUnit());
            } else {

                String lockValueA = lockRedisTemplate.opsForValue().get(lockKey);
                //查到锁的值并与当前时间比较检查其是否已经超时，若超时则可以重新获取锁
                if (lockValueA!=null && System.currentTimeMillis() > Long.valueOf(lockValueA)){
                    //通过用当前时间戳 getAndSet 操作会给对应的key设置新的值并返回旧值，这是一个原子操作
                    String lockValueB = lockRedisTemplate.opsForValue().getAndSet(lockKey,String.valueOf(System.currentTimeMillis()+lockTime));
                    //redis返回nil,则说明该值已经无效
                    if (lockValueB == null && StringUtils.pathEquals(lockValueA,lockValueB)){
                        //获取锁成功
                        lockRedisTemplate.expire(lockKey, lock.expire(), lock.timeUnit());
                    }else {
                        //获取锁失败
                        throw new RuntimeException("请勿重复请求");
                    }

                }
                //按理来说 我们应该抛出一个自定义的 CacheLockException 异常;
                throw new RuntimeException("请勿重复请求");
            }
            try {
                return pjp.proceed();
            } catch (Throwable throwable) {
                throw new RuntimeException("系统异常");
            }
        } finally {

            //如果演示的话需要注释该代码;实际应该放开
//             lockRedisTemplate.delete(lockKey);

        }
    }
}
