package com.xrafece.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Xrafece
 */
public class DataSourceTest {

    private String driver;
    private String url;
    private String username;
    private String password;

    @Before
    public void initProperties() {
        ResourceBundle jdbc = ResourceBundle.getBundle("jdbc");
        driver = jdbc.getString("jdbc.driver");
        url = jdbc.getString("jdbc.url");
        username = jdbc.getString("jdbc.username");
        password = jdbc.getString("jdbc.password");
    }

    @Test
    public void C3P0Test() throws PropertyVetoException, SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void druidTest() throws PropertyVetoException, SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://49.234.189.173:3306/one2");
        druidDataSource.setUsername("one2");
        druidDataSource.setPassword("46csRSe7AZ4css4X");
        Connection connection = druidDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void druidDatasourceTest() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void C3P0DatasourceTest() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComboPooledDataSource comboPooledDataSource = context.getBean(ComboPooledDataSource.class);
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
