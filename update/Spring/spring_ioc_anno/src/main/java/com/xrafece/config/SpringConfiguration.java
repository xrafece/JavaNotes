package com.xrafece.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/**
 * @author Xrafece
 */
@Configuration
@ComponentScan("com.xrafece")
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {

}
