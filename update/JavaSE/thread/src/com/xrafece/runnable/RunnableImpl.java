package com.xrafece.runnable;

/**
 * @author Xrafece
 */
public class RunnableImpl implements Runnable {
    /**
     * 重写接口方法，执行线程任务
     */
    @Override
    public void run() {
        System.out.println("This is a thread implement Runnable interface, name ----> " + Thread.currentThread().getName());
    }
}
