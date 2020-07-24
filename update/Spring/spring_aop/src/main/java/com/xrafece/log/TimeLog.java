package com.xrafece.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 记录运行时间
 *
 * @author Xrafece
 */
@Aspect
@Component
public class TimeLog {

    @Around("com.xrafece.log.PrintLog.serviceImpl()")
    public Object printRunTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("> now start timing for running.");
        Object o = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("> start time: " + new Date(startTime) + ", end time: " + new Date(endTime));
        System.out.println("> Method running " + (endTime - startTime) + " long second.");
        return o;
    }

}
