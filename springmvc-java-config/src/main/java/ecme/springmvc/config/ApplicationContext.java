package ecme.springmvc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ecme.springmvc.impl.BlogPostServiceImpl;
import ecme.springmvc.service.BlogPostService;

@EnableJpaRepositories(basePackages={"ecme.springmvc.dao"})
@EnableTransactionManagement
@Configuration
public class ApplicationContext {
	
	@Autowired
	Environment env;
	
	@Bean
	@Qualifier("mySqlDS")
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
	@Qualifier("dsEmbedded")
	public DataSource datasourceEmbedded(){
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase embeddedDatabase = builder
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("dbschema.sql")
				.addScript("test-data.sql")
				.build();
		return embeddedDatabase;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory em){
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(em);
		
		DatabasePopulatorUtils.execute(databasePopulator(), datasource());
		
		return jpaTransactionManager;
	}
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		return jpaVendorAdapter;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(datasource());
		em.setJpaVendorAdapter(jpaVendorAdapter());
		em.setPackagesToScan("ecme.springmvc.domain");
		
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		em.setJpaProperties(jpaProperties);
		
		return em; 
	}
	
	public DatabasePopulator databasePopulator(){
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.setContinueOnError(true);
		databasePopulator.addScript(new ClassPathResource("test-data.sql"));
		return databasePopulator;
	}
	
	/*@Bean
	public BlogPostService blogPostService(){
		return new BlogPostServiceImpl();
	}
	
	@Bean
	public UserService userService(){
		return new UserServiceImp();
	}
	*/
}
