package com.zjh.spring.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: zjh
 * @Date: 2019/5/11 22:16
 * @Version 1.0
 */

public class LoggingAspect {


    public void declareJointPointExpression(){

    }



    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        System.out.println("The method "+ methodName +" begins with" + Arrays.asList(args));
    }


    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+ methodName +" ends");
    }


    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+ methodName +" ends with "+result);
    }

    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method "+ methodName +" occurs exceptions: "+ex);
    }



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
    }
}
