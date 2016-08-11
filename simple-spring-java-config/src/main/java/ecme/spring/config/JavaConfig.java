package ecme.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import ecme.emailConfig.EmailConfig;
import ecme.spring.impl.BlogPostServiceImpl;
import ecme.spring.impl.MediumBlogPostServiceImpl;
import ecme.spring.impl.ServiceManagerImpl;
import ecme.spring.impl.WordpressBlogServiceImpl;
import ecme.spring.service.BlogPostService;
import ecme.spring.service.ServiceManager;

//@Configuration
@ComponentScan(basePackages={"ecme.spring"})
@Import(value={EmailConfig.class})
public class JavaConfig {
	
	@Bean
	public BlogPostService blogPostService(){
		return new BlogPostServiceImpl();
	}
	@Bean(name="WordpressPostService")
	public BlogPostService wordpressPostService(){
		return new WordpressBlogServiceImpl();
	}
	@Bean(name="MediumBlogPostService")
	public BlogPostService mediumPostService2(){
		return new MediumBlogPostServiceImpl();
	}
	@Bean
	public ServiceManager serviceManager(){
		
		return new ServiceManagerImpl();
	}
}
