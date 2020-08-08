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

1. 属性列表中每个键及其对应值是一个字符串。通常，每条属性展现为单行形式
2. 



#### YAML

##### 语法规则

1. 采用键值对形式，**冒号后面有一个空格**
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