package com.xrafece.dao;

import com.alibaba.druid.pool.DruidDataSource;
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
public class DataSourceTest {

    @Autowired
    private DruidDataSource druidDataSource;

    @Test
    public void testDruidDataSource() throws SQLException {
        System.out.println(druidDataSource.getConnection());
    }
}
