package com.xrafece.thread;

/**
 * @author Xrafece
 */
public class NewThread extends Thread {

    public NewThread() {
    }

    /**
     * 通过线程名称创建新线程
     *
     * @param name 线程名称
     */
    public NewThread(String name) {
        super(name);
    }

    /**
     * 重写父类的 run 方法，
     */
    @Override
    public void run() {
        System.out.println(currentThread().getName() + "----> 正在执行次线程");
    }
}
