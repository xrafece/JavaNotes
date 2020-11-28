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

- **可选类型声明：**不需要声明参数类型，编译器可以统一识别参数值。
- **可选的参数圆括号：**一个参数无需定义圆括号，但多个参数需要定义圆括号。
- **可选的大括号：**如果主体包含了一个语句，就不需要使用大括号。
- **可选的返回关键字：**如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。

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

Java 实现线程的三种方式

###  继承 `Thread` 类

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

### 实现 `Runnable` 接口

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

