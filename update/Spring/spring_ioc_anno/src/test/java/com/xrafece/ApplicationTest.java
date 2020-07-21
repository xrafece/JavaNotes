package com.xrafece;

import com.xrafece.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Xrafece
 */
@RunWith(SpringRunner.class)
// @ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = SpringConfiguration.class)
public class ApplicationTest {

    @Autowired
    private DataSource dataSource;
    @Qualifier("druidDataSource")
    @Autowired
    private DataSource druidDataSource;


    @Test
    public void test() throws SQLException {
        System.out.println(druidDataSource.getConnection());
    }
}
