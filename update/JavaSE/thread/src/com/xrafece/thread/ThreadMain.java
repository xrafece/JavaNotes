package com.xrafece.thread;

/**
 * @author Xrafece
 */
public class ThreadMain {
    public static void main(String[] args) {
        NewThread newThread1 = new NewThread();
        // 使用start方法开始新线程
        newThread1.start();

        NewThread newThread2 = new NewThread("新线程");
        newThread2.start();
    }
}
