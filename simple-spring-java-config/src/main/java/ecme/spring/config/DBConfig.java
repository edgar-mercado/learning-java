package ecme.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ecme.spring.domain.DataSource;

@Configuration
public class DBConfig {
	
	@Bean
	public DataSource dataSource(){
		DataSource ds= new DataSource();
		ds.setUrl("http:localhost");
		ds.setUsername("root");
		ds.setPsw("foo");
		
		return ds;
		
	}
}
