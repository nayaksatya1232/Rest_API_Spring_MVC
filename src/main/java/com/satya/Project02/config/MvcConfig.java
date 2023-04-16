package com.satya.Project02.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan("com.satya.Project02")
@EnableTransactionManagement
public class MvcConfig implements WebMvcConfigurer {
	@Bean
	public Properties getProperties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.setProperty("hibernate.show_sql", "true");
		return prop;
	}
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/project02");
		ds.setUsername("root");
		ds.setPassword("1234");
		return ds;
	}
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(getDataSource());
		sf.setHibernateProperties(getProperties());
		sf.setPackagesToScan("com.satya.Project02");
		
		return sf;
	}

	@Bean
	public HibernateTemplate getHbTemplate() {
		HibernateTemplate hb = new HibernateTemplate();
		hb.setSessionFactory(getSessionFactory().getObject());
		return hb;
	}

	@Bean
	public HibernateTransactionManager getTransaction() {
		HibernateTransactionManager hbManager = new HibernateTransactionManager();
		hbManager.setSessionFactory(getSessionFactory().getObject());
		return hbManager;
	}
}
