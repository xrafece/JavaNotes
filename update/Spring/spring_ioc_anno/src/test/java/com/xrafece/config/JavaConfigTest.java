package com.xrafece.config;

import com.xrafece.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Xrafece
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=SpringConfiguration.class)
public class JavaConfigTest {

    //容器中有两个数据源接口实现类对象，不添加次注解 Spring 无法自动匹配 bean
    @Qualifier("comboPooledDataSource")
    @Autowired
    private DataSource comboPooledDataSource;
    @Autowired
    private UserController userController;

    @Test
    public void c3p0Test() throws SQLException {
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testUserController() {
        userController.showAllUser();
    }
}
