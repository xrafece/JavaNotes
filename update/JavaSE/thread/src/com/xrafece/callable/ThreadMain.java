package com.xrafece.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Xrafece
 */
public class ThreadMain {
    public static void main(String[] args) {
        // 创建 Callable<V> 接口实现类对象
        RunnableThreadImpl runnableThread = new RunnableThreadImpl();
        // 创建 FutureTask<V> 实例对象（包装器）包装 Callable<V> 接口实现类对象
        FutureTask<Integer> integerFutureTask = new FutureTask<>(runnableThread);
        // 调用线程启动方法开始线程任务。
        new Thread(integerFutureTask).start();
        // 使用 FutureTask 实例对象对象的get()方法获取线程任务的返回值
        try {
            System.out.println(integerFutureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // lambda 表达式
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> 10);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        // 匿名使用 FutureTask<V> 实例对象无法获取线程返回值，只能执行线程任务，次做法类似 runnable
        new Thread(new FutureTask<Integer>(() -> {
            System.out.println("new Thread.");
            return 0;
        })).start();
    }
}
