# Spring

Spring 内容偏向与复习，所以笔记较为简练。

- [IOC](#ioc)
  * [Bean](#bean)
    + [xml 配置](#xml-配置)
    + [Annotation (注解) 配置](#annotation-注解-配置)
  * [DI (依赖注入)](#di-依赖注入)
    + [xml 配置](#xml-配置-1)
      - [(有参)构造方法注入](#有参构造方法注入)
      - [set方法注入](#set方法注入)
    + [Annotation (注解) 配置](#annotation-注解-配置-1)
  * [全注解开发](#全注解开发)
  * [测试](#测试)
- [AOP](#aop)
  - [xml 配置](#xml-配置-2)
  - [Annotation (注解) 配置](#annotation-注解-配置-2)
  - [全注解开发](#全注解开发-1)

## IOC

Spring 常用配置文件名称 `applicationContext.xml`

* Beans Schema

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        https://www.springframework.org/schema/beans/spring-beans.xsd
">

     <!-- bean definitions here -->

</beans>
```

* Context Schema

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context 
        https://www.springframework.org/schema/context/spring-context.xsd
">

    <!-- bean definitions here -->

</beans>
```

* Aop Schema

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop 
        https://www.springframework.org/schema/aop/spring-aop.xsd
">

    <!-- bean definitions here -->

</beans>
```

### Bean

默认使用类的**无参构造方法**，没有无参构造方法需要进行依赖注入，否则会创建失败。

#### xml 配置

使用 `bean` 标签进行配置容器组件

```xml
<bean id="userDao" class="com.xrafece.dao.impl.UserDaoImpl"/>
```

**标签属性**(`bean`)

* `id` 唯一标识

* `class` 全限定类名

* `scope` 对象的作用范围

  * `singleton`  单例对象 默认值
  * `prototype`  多例对象

* `init-method`  生命周期中初始化对象时需要调用的方法

* `destroy-method` 生命周期中销毁对象时需要调用的方法

  

**实例化 Bean 的三种方式**

1. 无参**构造**方法实例化

   ```xml
   <!--使用默认无参构造方法创建 bean-->
   <bean id="userDao" class="com.xrafece.dao.impl.UserDaoImpl"/>
   ```

2. 工厂**静态**方法实例化

   ```xml
   <!--使用静态工厂实例化 bean ，标签的 class 属性指向静态工厂，通过 factory-method 属性指向工厂具体构建 bean 的方法-->
   <bean id="userDaoStatic" class="com.xrafece.factory.StaticFactory" factory-method="getUserDaoStatic"/>
   ```

   工厂类 `StaticFactory.java`

   ```java
   package com.xrafece.factory;
   
   import com.xrafece.dao.UserDao;
   import com.xrafece.dao.impl.UserDaoImplStatic;
   
   /**
    * 静态工厂类
    *
    * @author Xrafece
    */
   public class StaticFactory {
   
       /**
        * 模拟静态工厂实例化对象
        *
        * @return UserDao接口实现类对象
        */
       public static UserDao getUserDaoStatic() {
           UserDao userDao = new UserDaoImplStatic();
           System.out.println("UserDao is be made by Static factory.");
           return userDao;
       }
   }
   ```

3. 工厂**实例**方法实例化

   ```xml
   <!--使用实例工厂实例化 bean ，和默认创建 bean 时 class 属性一致，但是需要使用 factory-bean 属性指向实例工厂 bean-->
   <bean id="userDaoDynamic" class="com.xrafece.dao.impl.UserDaoImplDynamic" factory-bean="dynamicFactory"/>
   <!--实例工厂 bean-->
   <bean id="dynamicFactory" class="com.xrafece.factory.DynamicFactory"/>
   ```
   
   工厂类 `DynamicFactory.java`
   
   ```java
   package com.xrafece.factory;
   
   import com.xrafece.dao.UserDao;
   import com.xrafece.dao.impl.UserDaoImplDynamic;
   
   /**
    * 实例工厂类
    *
    * @author Xrafece
    */
   public class DynamicFactory {
       /**
        * 模拟实例工厂实例化对象
        *
        * @return UserDao接口实现类对象
        */
       public UserDao getUserDaoDynamic() {
           UserDao userDao = new UserDaoImplDynamic();
           System.out.println("UserDao is made in Dynamic Factory.");
           return userDao;
       }
   }
   ```
   
#### Annotation (注解) 配置

* `@Component` 作用相当于上面的 `bean` 标签，用于实例化 bean

* `@Controller` 在 web 层用于实例化 bean

* `@Service` 在 service 层用于实例化 bean

* `@Repository` 在 dao 层用户实例化 bean

  ------

* `@Scope` 相当于上面 `scope` 属性，标注 bean 的作用范围

* `@PostConstruct` 相当于上面 `init-method` 属性，标注该方法是 bean 的初始化方法

* `@PreDestroy` 相当于上面 `destroy-method` 属性，标注该方法是 bean 的销毁方法

使用注解以后需要在 `applicationContext.xml` 配置注解扫描包路径 `<context:component-scan/>`

### DI (依赖注入)

**依赖注入的数据类型**

* 普通数据类型
* 引用数据类型
* 集合数据类型
#### xml 配置

##### (有参)构造方法注入

在 `bean` 标签中使用 `constructor-arg` 标签进行依赖注入。

当 bean 中没有**无参构造方法**时，必须采用构造方法的方式进行依赖注入，否则 IOC 容物无法创建 bean

**标签属性**(`constructor-arg`)

* `type` 注入依赖的数据类型
* `index` 注入依赖的索引位置，索引从 0 开始
* `name` 注入依赖的名称
* `value` 注入依赖的值（普通数据类型，指 String 和基本数据类型以及包装类）
* `ref` 注入依赖的引用（引用数据类型注入）

实体类 `User.java`

```java
package com.xrafece.entry;

import lombok.*;

import java.util.*;

/**
 * @author Xrafece
 */
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Date birthday;
    private List<String> favorites;
    private Map<String, Integer> index;
    private Properties properties;
}
```

配置文件 `applicationContext.xml`

```xml
<!--时间 bean，创建时调用Date的默然构造方法，即现在时间-->
<bean id="date" class="java.util.Date"/>

<!--构造方法依赖注入，在没有无参构造方法时必须采用-->
<bean id="user01" class="com.xrafece.entry.User">
    <!--普通数据类型-->
    <constructor-arg name="name" value="xrafece"/>
    <!--引用数据类型-->
    <constructor-arg name="birthday" ref="date"/>
    <!--集合数据类型-->
    <constructor-arg name="favorites">
        <list>
            <value>one</value>
            <value>two</value>
            <value>three</value>
        </list>
    </constructor-arg>
    <constructor-arg name="index">
        <map>
            <entry key="One" value="1"/>
            <entry key="Two">
                <value>2</value>
            </entry>
        </map>
    </constructor-arg>
    <!--List结构依赖注入时，list array set 标签等价-->
    <!--Map结构依赖注入时，map props 标签等价-->
    <constructor-arg name="properties">
        <props>
            <prop key="prop1">1</prop>
            <prop key="prop2">2</prop>
        </props>
    </constructor-arg>
</bean>
```

##### set方法注入

在 `bean` 标签中使用 `property` 标签进行依赖注入。

当 bean 中有 **set 方法**时，才可以使用 set 方法注入相应依赖项

**标签属性**(`property`)

* `name` 注入依赖的名称
* `value` 注入依赖的值（普通数据类型，指 String 和基本数据类型以及包装类）
* `ref` 注入依赖的引用（引用数据类型注入）

配置文件 `applicationContext.xml`

```xml
<!--时间 bean，创建时调用Date的默然构造方法，即现在时间-->
<bean id="date" class="java.util.Date"/>

<!--set 方法注入依赖，比如要有 set 方法可以进行依赖注入-->
<bean id="user02" class="com.xrafece.entry.User">
    <!--数据类型和构造方法依赖注入一致-->
    <property name="name" value="Nusplomerc"/>
    <property name="birthday" ref="date"/>
    <property name="favorites">
        <array>
            <value>01</value>
            <value>02</value>
        </array>
    </property>
    <property name="index">
        <props>
            <prop key="one">1</prop>
            <prop key="two">2</prop>
        </props>
    </property>
    <property name="properties">
        <map>
            <entry key="one" value="1"/>
            <entry key="two" value="2"/>
        </map>
    </property>
</bean>
```

#### Annotation (注解) 配置

* `@Autowired` 根据类型自动进行依赖注入
* `@Qualifier` 根据名称自动进行依赖注入
* `@Resource` 根据名称和类型进行匹配，然后自动进行依赖注入

使用注解以后需要在 `applicationContext.xml` 配置注解扫描包路径 `<context:component-scan/>`

### 全注解开发

在使用上面 **bean** 注解配置的时候，需要在 `applicationContext.xml` 文件中添加以下代码

```xml
<!--开启注解组件扫描，配置扫描包基路径-->
<context:component-scan base-package="com.xrafece"/>
```

而且如果需要配置第三方 bean 时，仍旧需要添加 `bean` 标签进行依赖注入，编码流程繁琐。

```xml
<!--激活属性占位符${...}，配置 properties 文件位置，分离配置耦合-->
<context:property-placeholder location="classpath:jdbc.properties"/>

<!--配置 c3p0 数据源（数据库连接池）-->
<bean id="comboPooledDataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
   <property name="driverClass" value="${jdbc.driver}"/>
   <property name="jdbcUrl" value="${jdbc.url}"/>
   <property name="user" value="${jdbc.username}"/>
   <property name="password" value="${jdbc.password}"/>
</bean>

<!--配置 druid 数据源， 没有使用占位符分离配置-->
<bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
   <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
   <property name="url" value="jdbc:mysql:///one2"/>
   <property name="username" value="xxxx"/>
   <property name="password" value="xxxxxx"/>
</bean>
<!--以上两个 bean 展示了实际开发中如何使用依赖注入给我们无法修改的第三方引用 jar 包中所需对象-->
```

`jdbc.properties` 配置文件

```properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql:///one2
jdbc.username=xxxx
jdbc.password=xxxxxx
```

所以 **Spring** 推出了新的注解来实现全注解开发，也为时下流行的 **SpringBoot** 奠定基础。

* `@Configuration` 指定当前类是 Spring 配置类，当创建容器时会从该类开始加载注解
* `@ComponentScan` 指定 IOC 容器创建时扫描需要扫描的包
* `@Bean` 指定方法返回值是一个 IOC 容器中的 bean ，唯一标识默认为方法名称，可指定名称
* `@PropertySource` 激活该类使用属性占位符 `$(...}` 用于指定配置文件属性
* `@Import` 导入其他 Java 配置类

配置类 `SpringConfiguration.java`

```java
package com.xrafece.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Xrafece
 */
//表示这是一个 Spring JavaConfig 类
@Configuration
//需要扫描注解的基本包路径，多个路径可以用数组表示或者使用 @ComponentScans 注解
@ComponentScan("com.xrafece")
//导入另外一个配置类
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {

}
```

数据源配置类 `DataSourceConfiguration.java`

```java
package com.xrafece.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 数据源对象配置类
 * @author Xrafece
 */
//激活属性占位符，并标注属性配置文件位置
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    // 使用 @Bean 注解，表示该方法返回值是一个要放入 ioc 容器中的 bean，属性值为 bean 的唯一标识
    // 默认属性表示方法为 bean 的唯一标识
    @Bean("comboPooledDataSource")
    public DataSource getComboPooledDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        return comboPooledDataSource;
    }

    // 省略写法，容器中 bean 的名称为 druidDataSource
    @Bean
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
```

### 测试

使用 `@RunWith(SpringJUnit4ClassRunner.class)` 注解标注测试类，并且使用 `@ContextConfiguration` 注解标注配置文件的位置（默认为 xml 文件，或者使用 classes 属性传递类文件），就可以在创建 IOC 容器以后进行 bean 测试，使用时只需要使用 `@Autowired` 注解自动装配就可以使用。

测试类 `ApplicationTest.java`

```java
package com.xrafece;

import com.xrafece.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Xrafece
 */
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = SpringConfiguration.class)
public class ApplicationTest {

    @Qualifier("druidDataSource")
    @Autowired
    private DataSource druidDataSource;
    
    @Test
    public void test() throws SQLException {
        System.out.println(druidDataSource.getConnection());
    }
}
```

在测试类的注解中常用写法 `@RunWith(SpringRunner.class)` ，经过查看 `SpringRunner.java` 源码后会发现，这种写法更加简洁，但功能是一样的。 

```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.springframework.test.context.junit4;

import org.junit.runners.model.InitializationError;

public final class SpringRunner extends SpringJUnit4ClassRunner {
    public SpringRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }
}
```

- [IOC](#ioc)
- [AOP](#aop)
  - [xml 配置](#xml-配置-2)
  - [Annotation (注解) 配置](#annotation-注解-配置-2)
  - [全注解开发](#全注解开发-1)

------

## AOP

AOP 就是面向切面编程，也是 Spring 的核心之一，使用 Spring AOP 之前需要先了解以下概念。

* **Target** (目标对象) ：代理的目标对象
* **Proxy** (代理) ：目标类被增强以后产生的代理对象
* **Joinpoint** (连接点) ：所有可以被增强的点都叫做连接点（Spring 只支持方法类型的连接点，所以这里指的是所有可被增强的方法）
* **Pointcut** (切入点) ：我们需要增强处理的连接点
* **Advice** (通知/增强) ：拦截到连接点以后要做的事情就是通知，即增强处理的具体做法
* **Aspect** (切面) ：切入点和通知（增强）的结合
* **Advisor** (增强器/通知器) ：用来筛选那些连接点需要增强（切入点）
* **Weaving** (织入)  ：把增强应用到目标对象来创建代理对象的过程叫做织入。Aspectj 采用编译期织入和装载期织入，而 Spring 采用动态代理织入

### xml 配置

使用 `aop` 标签进行配置

* `<aop:config>` 开始配置 AOP
* `<aop:pointcut>` 配置切点表达式
* `<aop:aspect>` 配置切面
  * `<aop:before` 前置通知
  * `<aop:after-returning` 后置通知
  * `<aop:after-throwing` 异常通知
  * `<aop:after` 最终通知
  * `<aop:around` 环绕通知
* `<aop:advisor` 配置增强器

标签属性(`aop`)

* `id` 唯一标识，切点表达式，切面和增强器有这个属性
* `ref` 引用值，可以引用容器中任意一个 bean ，切面和增强器的属性，用来配置某个 bean 是一个切面或者增强器
* `pointcut` 切点表达式，这是每个通知类型的属性，用来配置通知增强的切入点
* `pointcut-ref` 切点表达式引用，作用和切点表达式属性一致，使用此属性需要使用 `<aop:pointcut>` 标签将切点表达式进行提取，然后通过切点表达式的唯一标识进行引用
* `expression` 切点表达式，切点表达式标签特有属性，用来配置提取出来的切点表达式

**切点表达式语法**

> **execution([修饰符] 返回值类型 包名.类名.方法名(参数))**

1. 修饰符可以省略
2. 返回值类型、包名、类名、方法名可以使用 `*` 表示任意
3. 包名与类名之间的一个点 `.` 代表当前包下的类，两个点 `..` 表示当前包及其子包下的类
4. 参数列表可以使用两个点 `..` 表示任意个数、任意类型的参数列表

例如

```java
// 表示 com.xrafece.service.impl.UserServiceImpl 类中无返回值的 listAllUser() 方法
// 单一指定到某一个方法
execution(void com.xrafece.service.impl.UserServiceImpl.listAllUser())

// 表示 com.xrafece.service.impl.UserServiceImpl 类中所有无返回值方法
// 匹配一部分方法
execution(void com.xrafece.service.impl.UserServiceImpl.*(..))

// 表示 com.xrafece.service.impl 包下所有类中所有方法
execution(* com.xrafece.service.impl.*.*(..))
    
// 表示 com.xrafece.service 包及其子包下所有类中所有方法
execution(* com.xrafece.service..*.*(..))

// 表示所有类中所有方法
execution(* *..*.*(..))
```

注：配置切面和增强器之前要先把要用到的切面类、增强器类、被增强的类都放入 IOC 容器，便于容器管理。

### Annotation (注解) 配置

* `@Aspect` 标注该类是一个切面类

  * `@Before` 标注该方法是一个前置通知，属性值为切点表达式
  * `@AfterReturning` 标注该方法是一个后置通知，属性值为切点表达式
  * `@AfterThrowing` 标注该方法是一个前置通知，属性值为切点表达式
  * ` @After` 标注该方法是一个前置通知，属性值为切点表达式
  * `@Around` 标注该方法是一个前置通知，属性值为切点表达式

* ` @Pointcut` 标注到方法，属性值是切面表达式，可以使用被标注方法的全限定名代替以上五种通知类型的切点表达式

  在同一个类中可以直接引用方法代替切点表达式

  ```java
  @After("service()")
  public void printCopyRightAfterAll() {
      System.out.println("@@@@@@@@@@@@@@@@@@@@@.Xrafece Log Method, Thanks for using.@@@@@@@@@@@@@@@@@@@@@");
  }
  
  @Pointcut("execution(* com.xrafece.service..*.*(..))")
  public void service() {
  }
  
  @Pointcut("execution(* com.xrafece.service.impl.*.*(..))")
  public void serviceImpl() {
  }
  ```

  而另一个类如果要使用这个类中另一个切点表达式，需要使用全限定名

  另一个类

  ```java
  @Around("com.xrafece.log.PrintLog.serviceImpl()")
  public Object printRunTime(ProceedingJoinPoint proceedingJoinPoint) {
  // ...
  }
  ```

  （具体细节可以参考另一个文件夹中源码 `spring_aop` ）

  使用注解以后需要在 `applicationContext.xml` 激活 AOP 自动代理 `<aop:aspectj-autoproxy/>`

### 全注解开发

注解配置 AOP 时 `applicationContext.xml` 

```xml
<!--使用注解开发的时候需要开启自动代理-->
<aop:aspectj-autoproxy/>
<!--开启注解扫描-->
<context:component-scan base-package="com.xrafece"/>
```

基于全注解开发思想，只需要在 JavaConfig 类中添加 `@EnableAspectJAutoProxy` 注解即可开启自动代理

Spring 配置类 `SpringConfig.java`

```java
package com.xrafece.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Xrafece
 */

@Configuration
@ComponentScan("com.xrafece")
@Import(AopConfig.class)
public class SpringConfig {
}
```

AOP 配置类 `AopConfig.java`

```java
package com.xrafece.config;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Xrafece
 */

// 开始自动自动代理
@EnableAspectJAutoProxy
public class AopConfig {
}
```

