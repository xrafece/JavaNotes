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
   
   ```

2. 工厂**静态**方法实例化

   ```xml
   
   ```

   

3. 工厂**实例**方法实例化

   ```xml
   
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

#### xml 配置

#### Annotation (注解) 配置

* `@Autowired` 根据类型进行依赖注入

* `@Qualifier("druidDataSource")` 在 web 层用于实例化 bean

* `@Service` 在 service 层用于实例化 bean
