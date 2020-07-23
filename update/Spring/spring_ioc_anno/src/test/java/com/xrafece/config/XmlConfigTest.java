package com.xrafece.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.xrafece.dao.impl.UserDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

/**
 * @author Xrafece
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class XmlConfigTest {

    @Autowired
    private DruidDataSource druidDataSource;
    @Autowired
    private UserDaoImpl userDaoImpl;

    @Test
    public void druidTest() throws SQLException {
        System.out.println(druidDataSource.getConnection());
    }

    @Test
    public void userDaoTest() {
        userDaoImpl.listAllUser();
    }
}
