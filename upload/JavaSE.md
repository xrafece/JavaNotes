# JavaSE

**三目运算符**

> `<表达式1> ? <表达式2> : <表达式3>;`

先求表达式1的值，如果为真，则执行表达式2，并返回表达式2的结果;如果表达式1的值为假，则执行表达式3，并返回表达式3的结果。

```java
// 取两个数中最大值
max = (x > y) ? x : y;
// 括号可以省略
min = x < y ? x : y;
```

条件运算符是右结合的，也就是说，从右向左分组计算。

例如，a ? b : c ? d : e将按a ? b : (c ? d : e)执行

## Lambda 表达式

`@Since JDK1.8` 从 JDK 8 开始， Java 推出了 Lambda 表达式



当我们使用某些特殊接口时，

```java
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
        
}
```

其中涉及的  `RunnableImpl.java` 类

```java
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
```

从中我们可以发现一个问题，其中冗余代码很长，真正需要专注的业务代码只有 `run()` 方法的具体实现，（虽然我们可以使用智能的 IDE 自动生成）于是，Lambda 表达式来了。

```java
package com.xrafece.lambda;

/**
 * @author Xrafece
 */
public class Main {
    public static void main(String[] args) {

        // 使用lambda表达式进行简化以后
        new Thread(() -> System.out.println("lambda表达式简化的多线程创建任务正在执行......")).start();
    }
}
```

根据例子，不难看出，其中的接口有个很重要的特点，接口只有一个方法

### 使用前提

* **使用对象必须是接口，且接口必须只有一个抽象方法（函数式接口）**

### 语法形式

> `(parameters) -> expression` 或  `(parameters) -> { statements; }`

- **可选类型声明**：不需要声明参数类型，编译器可以统一识别参数值。
- **可选的参数圆括号**：一个参数无需定义圆括号，但多个参数需要定义圆括号。
- **可选的大括号**：如果主体包含了一个语句，就不需要使用大括号。
- **可选的返回关键字**：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。

### 实例

```java
// 1. 不需要参数,返回值为 5  
() -> 5  
  
// 2. 接收一个参数(数字类型),返回其2倍的值  
x -> 2 * x  
  
// 3. 接受2个参数(数字),并返回他们的差值  
(x, y) -> x – y  
  
// 4. 接收2个int型整数,返回他们的和  
(int x, int y) -> x + y  
  
// 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)  
(String s) -> System.out.print(s)
```

由于接口中方法参数类型和参数顺序都已经规定，返回值类型也已经确定，所以使用时可以省略大量代码，表达式可以自己推导出已经省略的内容。所以使用起来很方便。

## 函数式接口

函数式接口是一种特殊接口，接口中有且仅有一个抽象方法。

可以使用 `@FunctionalInterface` 注解标注接口，用以约束该接口符合函数式接口规范。

### 常用函数式接口

#### JDK

## 线程

### 创建线程的三种方式

1. 继承 `Thread` 类，[调用 `Thread`对象 的` start()` 启动线程](#继承-thread-类)
2. 实现 `Runnable` 接口，[调用 `Thread`对象 的` start()` 启动线程](实现-runnable-接口)
3. 实现 `Callable` 接口，并使用 `FutureTask` 对象，[调用 `Thread`对象 的` start()` 启动线程](#实现-callable-接口并使用-futuretask-对象)

####  继承 `Thread` 类

继承 `Thread` 类，重写 `run()` 方法执行线程任务，调用 `start()` 方法开启线程。

```java
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
```

```java
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
```

#### 实现 `Runnable` 接口

实现 `Runnable` 接口，实现类重写 `run()` 方法执行线程任务，通过 `Thread` 类的 `public Thread(Runnable target)` 构造方法创建 `Thread` 类对象，并调用 `start()` 开启线程。

```java
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
```

```java
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
```

相比直接继承 `Thread` 类，实现 `Runnable` 接口的方式实现了轻度解耦，线程任务和启动线程实现分离。

#### 实现 `Callable` 接口，并使用 `FutureTask` 对象

1. 创建 `Callable` 接口的实现类，并实现 `call()` 方法，该 `call()` 方法将作为线程执行体，并且有返回值

    ```java
    public interface Callable {
      V call() throws Exception;
    }
    ```

2. 创建 `Callable` 实现类的实例，使用 `FutureTask` 类来包装 `Callable` 对象，该 `FutureTask` 对象封装了该 `Callable` 对象的 `call()` 方法的返回值。（ `FutureTask` 是一个包装器，它通过接受 `Callable` 来创建，它同时实现了 `Future` 和 `Runnable` 接口。）

3. 使用 `FutureTask` 对象作为 `Thread` 对象的target创建并启动新线程

4. 调用 `FutureTask` 对象的 `get()` 方法来获得子线程执行结束后的返回值

```java
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
```

```java
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
```

#### 创建线程的三种方式的对比


* 使用实现`Runnable`、`Callable`接口的方式创建多线程时：

  优点：

  1. 线程类只是实现了`Runnable`接口或`Callable`接口，还可以继承其他类。
  2. 在这种方式下，多个线程可以共享同一个target对象，所以非常适合多个相同线程来处理同一份资源的情况，从而可以将CPU、代码和数据分开，形成清晰的模型，较好地体现了面向对象的思想。

  缺点：

  1. 编程稍微复杂，如果要访问当前线程，则必须使用 `Thread.currentThread()` 方法。

* 使用继承`Thread`类的方式创建多线程时：

  优点：

  1. 编写简单，如果需要访问当前线程，则无需使用`Thread.currentThread()`方法，直接使用`this`即可获得当前线程。

  缺点：

  1. 线程类已经继承了`Thread`类，所以不能再继承其他父类。

* `Runnable`和`Callable`的区别：
  
  1. `Callable`规定（重写）的方法是`call()`，`Runnable`规定（重写）的方法是`run()`。
  2. `Callable`的任务执行后可返回值，而`Runnable`的任务是不能返回值的。
  3. `call()`方法可以抛出异常，`run()`方法不可以。
  4. 运行`Callable`任务可以拿到一个`Future`对象，表示异步计算的结果。它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。通过`Future`对象可以了解任务执行情况，可取消任务的执行，还可获取执行结果。

### 线程池

#### 1、线程池的优势

（1）、降低系统资源消耗，通过重用已存在的线程，降低线程创建和销毁造成的消耗；
 （2）、提高系统响应速度，当有任务到达时，通过复用已存在的线程，无需等待新线程的创建便能立即执行；
 （3）方便线程并发数的管控。因为线程若是无限制的创建，可能会导致内存占用过多而产生OOM，并且会造成cpu过度切换（cpu切换线程是有时间成本的（需要保持当前执行线程的现场，并恢复要执行线程的现场））。
 （4）提供更强大的功能，延时定时线程池。

#### 2、线程池的主要参数



```cpp
public ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
    this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
         Executors.defaultThreadFactory(), defaultHandler);
}
```

1、corePoolSize（线程池基本大小）：当向线程池提交一个任务时，若线程池已创建的线程数小于corePoolSize，即便此时存在空闲线程，也会通过创建一个新线程来执行该任务，直到已创建的线程数大于或等于corePoolSize时，（除了利用提交新任务来创建和启动线程（按需构造），也可以通过 prestartCoreThread() 或 prestartAllCoreThreads() 方法来提前启动线程池中的基本线程。）

2、maximumPoolSize（线程池最大大小）：线程池所允许的最大线程个数。当队列满了，且已创建的线程数小于maximumPoolSize，则线程池会创建新的线程来执行任务。另外，对于无界队列，可忽略该参数。

3、keepAliveTime（线程存活保持时间）当线程池中线程数大于核心线程数时，线程的空闲时间如果超过线程存活时间，那么这个线程就会被销毁，直到线程池中的线程数小于等于核心线程数。

4、workQueue（任务队列）：用于传输和保存等待执行任务的阻塞队列。

5、threadFactory（线程工厂）：用于创建新线程。threadFactory创建的线程也是采用new Thread()方式，threadFactory创建的线程名都具有统一的风格：pool-m-thread-n（m为线程池的编号，n为线程池内的线程编号）。

5、handler（线程饱和策略）：当线程池和队列都满了，再加入线程会执行此策略。

#### 3、线程池流程

![img](https:////upload-images.jianshu.io/upload_images/6024478-88ee7b20f8f45825.png?imageMogr2/auto-orient/strip|imageView2/2/w/937/format/webp)

线程池流程

1、判断核心线程池是否已满，没满则创建一个新的工作线程来执行任务。已满则。
 2、判断任务队列是否已满，没满则将新提交的任务添加在工作队列，已满则。
 3、判断整个线程池是否已满，没满则创建一个新的工作线程来执行任务，已满则执行饱和策略。

（1、判断线程池中当前线程数是否大于核心线程数，如果小于，在创建一个新的线程来执行任务，如果大于则
 2、判断任务队列是否已满，没满则将新提交的任务添加在工作队列，已满则。
 3、判断线程池中当前线程数是否大于最大线程数，如果小于，则创建一个新的线程来执行任务，如果大于，则执行饱和策略。）

#### 4、线程池为什么需要使用（阻塞）队列？

回到了非线程池缺点中的第3点：
 1、因为线程若是无限制的创建，可能会导致内存占用过多而产生OOM，并且会造成cpu过度切换。

另外回到了非线程池缺点中的第1点：
 2、创建线程池的消耗较高。
 或者下面这个网上并不高明的回答：
 2、线程池创建线程需要获取mainlock这个全局锁，影响并发效率，阻塞队列可以很好的缓冲。

#### 5、线程池为什么要使用阻塞队列而不使用非阻塞队列？

阻塞队列可以保证任务队列中没有任务时阻塞获取任务的线程，使得线程进入wait状态，释放cpu资源。
 当队列中有任务时才唤醒对应线程从队列中取出消息进行执行。
 使得在线程不至于一直占用cpu资源。

（线程执行完任务后通过循环再次从任务队列中取出任务进行执行，代码片段如下
 while (task != null || (task = getTask()) != null) {}）。

不用阻塞队列也是可以的，不过实现起来比较麻烦而已，有好用的为啥不用呢？

#### 6、如何配置线程池

CPU密集型任务
 尽量使用较小的线程池，一般为CPU核心数+1。 因为CPU密集型任务使得CPU使用率很高，若开过多的线程数，会造成CPU过度切换。

IO密集型任务
 可以使用稍大的线程池，一般为2*CPU核心数。 IO密集型任务CPU使用率并不高，因此可以让CPU在等待IO的时候有其他线程去处理别的任务，充分利用CPU时间。

混合型任务
 可以将任务分成IO密集型和CPU密集型任务，然后分别用不同的线程池去处理。 只要分完之后两个任务的执行时间相差不大，那么就会比串行执行来的高效。
 因为如果划分之后两个任务执行时间有数据级的差距，那么拆分没有意义。
 因为先执行完的任务就要等后执行完的任务，最终的时间仍然取决于后执行完的任务，而且还要加上任务拆分与合并的开销，得不偿失。

#### 7、java中提供的线程池

Executors类提供了4种不同的线程池：newCachedThreadPool, newFixedThreadPool, newScheduledThreadPool, newSingleThreadExecutor

![img](https:////upload-images.jianshu.io/upload_images/6024478-9e47d2796c8ab1aa.png?imageMogr2/auto-orient/strip|imageView2/2/w/1200/format/webp)

java线程池对比

1、newCachedThreadPool：用来创建一个可以无限扩大的线程池，适用于负载较轻的场景，执行短期异步任务。（可以使得任务快速得到执行，因为任务时间执行短，可以很快结束，也不会造成cpu过度切换）

2、newFixedThreadPool：创建一个固定大小的线程池，因为采用无界的阻塞队列，所以实际线程数量永远不会变化，适用于负载较重的场景，对当前线程数量进行限制。（保证线程数可控，不会造成线程过多，导致系统负载更为严重）

3、newSingleThreadExecutor：创建一个单线程的线程池，适用于需要保证顺序执行各个任务。

4、newScheduledThreadPool：适用于执行延时或者周期性任务。

#### 8、execute()和submit()方法

1、execute()，执行一个任务，没有返回值。
 2、submit()，提交一个线程任务，有返回值。
 submit(Callable<T> task)能获取到它的返回值，通过future.get()获取（阻塞直到任务执行完）。一般使用FutureTask+Callable配合使用（IntentService中有体现）。

submit(Runnable task, T result)能通过传入的载体result间接获得线程的返回值。
 submit(Runnable task)则是没有返回值的，就算获取它的返回值也是null。

Future.get方法会使取结果的线程进入阻塞状态，知道线程执行完成之后，唤醒取结果的线程，然后返回结果。

