package com.xrafece.callable;

import java.util.concurrent.Callable;

/**
 * Callable<V> 接口实现类
 *
 * @author Xrafece
 */
public class RunnableThreadImpl implements Callable<Integer> {
    /**
     * 接口可以指定泛型，用以作为返回值类型，重写 call() 方法执行线程任务并返回值
     *
     * @return 线程任务需要的返回值
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        System.out.println("This is callable Thread. Return an integer.");
        return 10010;
    }
}
