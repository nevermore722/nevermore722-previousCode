package com.zjh.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author: zjh
 * @Date: 2019/5/13 17:58
 * @Version 1.0
 */

/**
 * 可以使用@Order 注解指定切面的优先级，值越小优先级越高
 */
@Aspect
@Component
@Order(1)
public class VlidationAspect {

    @Before("LoggingAspect.declareJointPointExpression()")
    public void validateArgs(JoinPoint joinPoint){
        System.out.println("-->validate:"+Arrays.asList(joinPoint.getArgs()));
    }
}
