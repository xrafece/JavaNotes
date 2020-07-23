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
