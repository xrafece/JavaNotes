# SpringBoot

## 配置文件

> `SpringApplication` loads properties from `application.properties` files in the following locations and adds them to the Spring `Environment`:
>
> 1. A `/config` subdirectory of the current directory
> 2. The current directory
> 3. A classpath `/config` package
> 4. The classpath root
>
> The list is ordered by precedence (properties defined in locations higher in the list override those defined in lower locations).

### Properties



### YAML

#### 语法规则

1. 采用键值对形式，冒号后面有一个空格
2. 大小写敏感
3. 使用缩进表示层级关系
4. 不允许使用 TAB 键缩进，只允许使用空格
5. 缩进长度没有限制，只要想用层级元素缩进对齐即可
6. 使用#进行注释

#### 数据结构

```yml
yaml:
  str: "加上双引号以后字符会被转义\\"
  special-str: '单引号或者不加引号，字符不会被转义\\'
  num: 1234
  double-num: 5115.2
  date: 2020/02/02 20:20:20
  num-list: 1, 3, 5
  map: {String: Strin, ss: ssteri, dwdwa: sin}
  users:
    - id: 552
    - name: test1
      id: 1521
    - name: test2
      id: 234`
```



相比之下 YAML 文件层级表示更加清晰，但是可读性差，Prperties 文件可读性比较好