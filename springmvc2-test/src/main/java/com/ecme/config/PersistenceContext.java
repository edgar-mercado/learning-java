package com.ecme.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages={"com.ecme.dao"})
public class PersistenceContext {

	@Autowired
	Environment env;
	
	@Bean
	public DataSource datasource(){
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(env.getProperty("jdbc.driverClass"));
		dmds.setUrl(env.getProperty("jdbc.url"));
		dmds.setUsername(env.getProperty("jdbc.username"));
		dmds.setPassword(env.getProperty("jdbc.password"));
		System.out.println("****************************"+env.getProperty("jdbc.driverClass"));
		System.out.println("****************************"+env.getProperty("jdbc.url"));
		System.out.println("****************************"+env.getProperty("jdbc.username"));
		System.out.println("****************************"+env.getProperty("jdbc.password"));
		return dmds;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(datasource());
		em.setJpaVendorAdapter(jpaVendorAdapter());
		em.setPackagesToScan("com.ecme.domain");
		
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		em.setJpaProperties(jpaProperties);
		
		return em; 
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory em){
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(em);
		
		//DatabasePopulatorUtils.execute(databasePopulator(), datasource());
		
		return jpaTransactionManager;
	}
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		return jpaVendorAdapter;
	}
	
}
