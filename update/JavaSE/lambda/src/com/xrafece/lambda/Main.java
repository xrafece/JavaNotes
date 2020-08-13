package com.xrafece.lambda;

/**
 * @author Xrafece
 */
public class Main {
    public static void main(String[] args) {

        RunnableImpl run = new RunnableImpl();
        new Thread(run).start();
        // 使用匿名内部类,进行代码简化
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程任务执行中......");
            }
        };
        new Thread(runnable).start();
        // 再次进行简化
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("再次进行简化的多线程创建任务正在执行......");
            }
        }).start();
        // 使用lambda表达式进行简化
        new Thread(() -> System.out.println("lambda表达式简化的多线程创建任务正在执行......")).start();
    }
}
