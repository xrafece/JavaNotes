# 易班API使用笔记

## 易班`YBOpenApi.jar`使用

maven -> pom.xml 添加依赖

```xml
<dependencies>
    <dependency>
        <groupId>cn.yiban</groupId>
        <artifactId>openapi</artifactId>
        <scope>system</scope>
        <version>1.0</version>
        <systemPath>${project.basedir}/YBOpenApi.jar</systemPath>
    </dependency>
</dependencies>

<build>
    <resources>
        <resource>
            <directory>${project.basedir}</directory>
            <targetPath>BOOT-INF/lib</targetPath>
            <includes>
                <include>*.jar</include>
            </includes>
        </resource>
    </resources>
</build>

```

使用
