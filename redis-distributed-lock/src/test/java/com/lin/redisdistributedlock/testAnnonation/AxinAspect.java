package com.lin.redisdistributedlock.testAnnonation;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/9
 * \* Time: 11:40
 * \* Description:
 * \
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * @author Axin
 */

//匹配规则：
//
////匹配AOP对象的目标对象为指定类型的方法，即DemoDao的aop的代理对象
//@Pointcut("this(com.hhu.DemaoDao)")
//public void thisDemo() {
//    ...
//}

//通知类别：
//
//前置通知（Before advice）- 在目标方便调用前执行通知
//后置通知（After advice）- 在目标方法完成后执行通知
//返回通知（After returning advice）- 在目标方法执行成功后，调用通知
//异常通知（After throwing advice）- 在目标方法抛出异常后，执行通知
//环绕通知（Around advice）- 在目标方法调用前后均可执行自定义逻辑

//JoinPoint对象封装了SpringAop中切面方法的信息,在切面方法中添加JoinPoint参数,就可以获取到封装了该方法信息的JoinPoint对象. 注意：这用于非环绕通知


//方法名	功能
//Signature getSignature();	获取封装了署名信息的对象,在该对象中可以获取到目标方法名,所属类的Class等信息
//Object[] getArgs();	获取传入目标方法的参数对象
//Object getTarget();	获取被代理的对象
//Object getThis();	获取代理对象



@Aspect
@Component
public class AxinAspect {

    /**
     * 这里定义了一个总的匹配规则，以后拦截的时候直接拦截log()方法即可，无须去重复写execution表达式
     */
    @Pointcut("@annotation(Axin)")
    public void log() {
    }

    @Before("log()&&@annotation(axin)")
    public void doBefore(JoinPoint joinPoint, Axin axin) {
        System.out.println("******拦截前的逻辑******");
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数为:" + args[i]);
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());

        System.out.println("拦截的注解的参数：");
        System.out.println(axin.module());
        System.out.println(axin.desc());
    }

    @Around("log()&&@annotation(axin)")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, Axin axin) throws Throwable {
        System.out.println("环绕通知：");
        System.out.println(axin.module());
        System.out.println(axin.desc());
        Object result = null;
        result = proceedingJoinPoint.proceed();
        return result;
    }

    @After("log()")
    public void doAfter() {
        System.out.println("******拦截后的逻辑******");
    }
}
