package com.zjh.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.jws.Oneway;
import java.util.Arrays;

/**
 * @Author: zjh
 * @Date: 2019/5/11 22:16
 * @Version 1.0
 */
@Component
@Aspect
@Order(2)
public class LoggingAspect {

    /**
     * 定义一个方法，用于声明切入点表达式。一般地，该方法中再不需要添入其他的代码。
     * 使用@Pointcut 来声明切入点表达式。
     * 后面的其他通知直接使用方法名来引用当前切入点表达式。
     */
    @Pointcut("execution(public int com.zjh.spring.aop.ArithmeticCalculator.*(..))")
    public void declareJointPointExpression(){

    }


    /**
     * 在com.zjh.spring.aop.ArithmeticCalculator接口的每一个实现类的每一个方法开始之前执行一段代码
     */
    @Before("declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        System.out.println("The method "+ methodName +" begins with" + Arrays.asList(args));
    }


    /**
     * 在方法执行之后执行的代码，无论该方法是否异常
     * @param joinPoint
     */
    @After("declareJointPointExpression()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+ methodName +" ends");
    }

    /**
     * 在方法正常结束后执行的代码
     * 返回通知时可以访问到方法的返回值的
     * @param joinPoint
     */
    @AfterReturning(value = "declareJointPointExpression()"
                    ,returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+ methodName +" ends with "+result);
    }

    /**
     * 在目标方法出现异常时会执行的代码
     * 可以访问到异常对象；且可以指定在出现特定异常时再执行通知代码
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "declareJointPointExpression()",
                    throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+ methodName +" occurs exceptions: "+ex);
    }


    /**
     * 环绕通知需要携带ProceedingJoinPoint类型的参数
     * 环绕通知类似与动态代理的全过程：ProceedingJoinPoint类型的参数可以觉得是否执行目标方法
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值
     * @param pjd
     */
/*    @Around("execution(public int com.zjh.spring.aop.ArithmeticCalculator.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjd){

        Object result = null;
        String methodName = pjd.getSignature().getName();
        //执行目标方法
        try {
            //前置通知
            System.out.println("The method " +methodName +"begins with "+Arrays.asList(pjd.getArgs()));
            result = pjd.proceed();
            //后置通知
            System.out.println("The method "+methodName+" ends with "+result);
        } catch (Throwable throwable) {
            //异常通知
            System.out.println("The method occurs exception:"+throwable);
            throwable.printStackTrace();
            throw new RuntimeException(throwable);
        }
        //后置通知
        System.out.println("The method "+methodName+" ends");

        System.out.println("aroundMethod");
        return result;
    }*/
}
