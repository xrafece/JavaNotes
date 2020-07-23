# Spring

Spring 内容偏向与复习，所以笔记较为简练。

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

### Bean

默认使用类的**无参构造方法**，没有无参构造方法会创建失败。

#### xml 配置

```xml
<bean id="userDao" class="com.xrafece.dao.impl.UserDaoImpl"/>
```

**基本属性**

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

