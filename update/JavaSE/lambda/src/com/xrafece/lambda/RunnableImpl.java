package com.xrafece.lambda;

/**
 * @author Xrafece
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+", 此线程创建了。");
    }
}
