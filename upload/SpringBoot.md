# SpringBoot

## 外置化配置

对于外置化配置，Spring Boot 支持多种方式

1. YAML 文件
2. properties 文件
3. 环境变量
4. 命令行参数

这些配置文件可以使用 `@Value` 注解将属性值直接注入 bean，也可以使用 `@ConfigurationProperties` 注解绑定到结构化对象

**配置文件加载顺序**

> `SpringApplication` loads properties from `application.properties` files in the following locations and adds them to the Spring `Environment`:
>
> 1. A `/config` subdirectory of the current directory
> 2. The current directory
> 3. A classpath `/config` package
> 4. The classpath root
>
> The list is ordered by precedence (properties defined in locations higher in the list override those defined in lower locations).

当使用 `application.properties` 文件（或 `application.yml` 文件）加载配置属性时，加载顺序如下：

1. `-file:/config` 项目根目录下的 config 子目录
2. `-file:/` 项目根目录
3. `-classpath:/config` 类路径下的  config 子目录
4. `-classpath:/` 类路径根目录

**列表顺序优先级由高到低，并且 properties 配置文件的优先级高于 yaml 文件**

### 配置文件

#### properties

##### 语法规则

1. 属性列表中每个键及其对应值是一个字符串。通常，每行存储一个属性值
2. 属性值字符串使用单引号和双引号都会被视为字符串一部分
3. 注释使用 # 或者 ！
4. 属性名和属性值之间的空格以及行首的空白和空行都会被忽略
5. 属性值以 `\` 反斜杠字符结尾表示属性值可以跨越多行
6. 可以使用转义字符，例如 `\n` 、 `\t`

##### 数据形式

```properties
# You are reading the ".properties" entry.
! The exclamation mark can also mark text as comments.
# The key and element characters #, !, =, and : are written with
# a preceding backslash to ensure that they are properly loaded.
website = http\://en.wikipedia.org/
language = English
# The backslash below tells the application to continue reading
# the value onto the next line.
message = Welcome to \
          Wikipedia!
# Add spaces to the key
key\ with\ spaces = This is the value that could be looked up with the key "key with spaces".
# Unicode
tab : \u0009
```

> In the example above, `website` would be a key, and its corresponding value would be`http://en.wikipedia.org/`. While the number sign (#) and the exclamation mark (!) marks text as comments, it has no effect when it is part of a property. Thus, the key`message` has the value `Welcome to Wikipedia!` and not `Welcome to Wikipedia`. Note also that all of the whitespace in front of `Wikipedia!` is excluded completely.

在上面的示例中，`website` 将是一个键，其对应的值将是`http://en.wikipedia.org/`。虽然数字符号（＃）和感叹号（！）将文本标记为注释，但是当它是属性的一部分时无效。因此，键 `message` 对应的值为 ``Welcome to Wikipedia!`` 而不是 `Welcome to Wikipedia`。另请注意，`Wikipedia!` 前面的所有空白被完全排除。

#### YAML

##### 语法规则

1. 采用键：值形式，**冒号后面有一个空格**
2. 大小写敏感
3. 使用缩进表示层级关系
4. 不允许使用 TAB 键缩进，只允许使用空格
5. 缩进长度没有限制，只要想用层级元素缩进对齐即可
6. 使用 # 进行注释
7. 字符串使用 `“ ”` 双引号，字符串中不会转义特殊字符，单引号或者不使用引号，特殊字符会被转义

##### 数据形式

```yml
yaml:
  str: "加上双引号以后字符会被转义\\"
  special-str: '单引号或者不加引号，字符不会被转义\\'
  num: 1234
  double-num: 5115.2
  date: 2020/02/02 20:20:20
  num-list: 1, 3, 5
  map: {key1: value1, key2: value2, key3: value3}
  users:
    - id: 552
    - name: test1
      id: 1521
    - name: test2
      id: 234
```

相比之下 YAML 文件层级表示更加清晰，但是可读性差，properties 文件可读性比较好

### 配置注入

首先添加依赖，用以加载 SpringBoot 元数据

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-configuration-processor</artifactId>
   <optional>true</optional>
</dependency>
```

#### Set 和 Get 方法绑定

在对应配置文件属性类添加 `@Component` 注解用以标注该类是 IOC 组件，然后用 `@ConfigurationProperties` 注解设定前缀属性，用以绑定配置文件中属性前缀。配置注入会依赖类的 Set 和 Get 方法。

例如，对于以上 yaml 属性，对应类 `YamlEntry.java` :

```java
package com.xrafece.entry;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Xrafece
 */
@Data
@Component
@ConfigurationProperties("yaml")
public class YamlEntry {
    private String str;
    private String specialStr;
    private Integer num;
    private Double doubleNum;
    private Date date;
    private List<Integer> numList;
    private Map<String, String> map;
    private Set<User> users;
}
```

> idea 运行时，需要 build class 才可以通过依赖加载元数据，从而出现代码提醒和补全

以上方式必须要添加  `@Component` 注解。但一般在配置类使用此配置属性类时，此类作用特殊，不需要将此类标记为组件。此时，只需要在配置类添加 `@EnableConfigurationProperties` 注解引入配置属性类即可。

```java
package com.xrafece.config;

import com.xrafece.entry.YamlEntry;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xrafece
 */
@Configuration
@EnableConfigurationProperties(YamlEntry.class)
public class YamlConfig {
}
```

#### 构造方法绑定

在对应配置文件属性类添加 `@ConfigurationProperties` 注解设定前缀属性，并且使用 `@ConstructorBinding` 注解用以标注构造方法绑定。绑定以后配置属性会使用构造方法进行注入，此时类可以没有 Set 和 Get 方法。

**注：**

1. **可以在类上使用 `@ConstructorBinding` 注解，此时类必须有且仅有一个有参构造方法**

2. **当有多个有参构造方法，需要在某个构造方法上使用注解，指定绑定唯一的构造方法**

   > If you have more than one constructor for your class you can also use `@ConstructorBinding` directly on the constructor that should be bound.

3. **当使用构造方法绑定时，必须使用 `@EnableConfigurationProperties` 或者配置属性扫描，而不能使用 `@Component` 、 `@Bean` 、 `@Import`等注解标注 bean** 

   >  To use constructor binding the class must be enabled using `@EnableConfigurationProperties` or configuration property scanning. You cannot use constructor binding with beans that are created by the regular Spring mechanisms (e.g. `@Component` beans, beans created via `@Bean` methods or beans loaded using `@Import`)

例如，配置文件 `application.properties`

```properties
properties.name=http://en.wikipedia.org/\
#\1212\24121
# "\" 用来表示当前属性值还未结束，可以换行，也可以不换行，他都会继续读取为当前属性的值
properties.file=D:one,\
  G:\\markdown\\Upload,\
  \\Home
properties.port=33051
```

对应配置属性类 `PropertiesEntry.java`

```java
package com.xrafece.entry;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Xrafece
 */
@Data
@ConfigurationProperties("properties")
@ConstructorBinding
public class PropertiesEntry {
    private String name;
    private Integer port;
    private List<String> file;

    public PropertiesEntry(String name, Integer port, List<String> file) {
        System.out.println("ConstructorBinging annotation run this constructor method by default.");
        this.name = name;
        this.port = port;
        this.file = file;
    }
}
```

配置类 `PropertiesConfig,java`

```java
package com.xrafece.config;

import com.xrafece.entry.PropertiesEntry;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xrafece
 */
@Configuration
@EnableConfigurationProperties(PropertiesEntry.class)
public class PropertiesConfig {
}
```



