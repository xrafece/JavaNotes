package com.xrafece.executor;

/**
 * @author Xrafece
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "名称的线程正在运行");
    }
}
