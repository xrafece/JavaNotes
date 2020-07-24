package com.xrafece.log;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 打印日志
 *
 * @author Xrafece
 */
@Aspect
@Component
public class PrintLog {
    /**
     * 当方法开始执行时打印日志
     */
    @Before("PrintLog.service()")
    public void printLogBeforeMethod() {
        System.out.println("Method starts. Please wait!   --------------------------------------------------------");
    }

    /**
     * 在方法执行结束时打印日志
     */
    @AfterReturning("service()")
    public void printLogAfterMethod() {
        System.out.println("--------------------------------------------------------   Method end. Thank you!");
    }

    /**
     * 在方法抛出异常时打印日志
     */
    @AfterThrowing("service()")
    public void printLogWhenThrowingException() {
        System.out.println("ERROR, THROWING EXCEPTION......");
    }

    /**
     * 无论方法是否正常运行，打印日志结尾
     */
    @After("service()")
    public void printCopyRightAfterAll() {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@.Xrafece Log Method, Thanks for using.@@@@@@@@@@@@@@@@@@@@@");
    }

    @Pointcut("execution(* com.xrafece.service..*.*(..))")
    public void service() {
    }

    @Pointcut("execution(* com.xrafece.service.impl.*.*(..))")
    public void serviceImpl() {
    }

}
