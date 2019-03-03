package com.student.fhms.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.student.fhms")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {

	// setup variable to hold properties
	@Autowired
	private Environment env;

	// Setup Logger for diagnostic
	Logger logger = Logger.getLogger(getClass().getName());

	// define a bean for viewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;

	}

	// define a bean for database (for app data and security data)
	@Bean
	public DataSource dataSource() {

		// create Connection Pool
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		// set jdbc driver class
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// logging database url and user to console
		logger.info("=====================> jdbc.url :"+env.getProperty("jdbc.url"));
		logger.info("=====================> jdbc.user :"+env.getProperty("jdbc.user"));
		
		// Set database Connection properties
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));

		// set connection pool properties
		dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return dataSource;
	}

	public int getIntProperty(String propertyName) {
		String propValue = env.getProperty(propertyName);
		int intPropValue = Integer.parseInt(propValue);
		return intPropValue;

	}
	@Bean
	public String showMessage(){
		return "OOOOOOOOO Hello World OOOOOOOOOOOOOOO";
	}

}
