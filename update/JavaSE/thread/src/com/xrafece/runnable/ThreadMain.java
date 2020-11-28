package com.xrafece.runnable;

/**
 * @author Xrafece
 */
public class ThreadMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableImpl());
        // 调用start方法启动线程
        thread.start();
        //匿名内部类+lambda表达式简写。
        new Thread(() -> {
            Thread.currentThread().setName("匿名内部类线程");
            System.out.println("This is a new Thread" + Thread.currentThread().getName());
        }).start();
    }
}
