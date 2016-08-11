package ecme.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Configuration class dispatcher-servlet.xml
 * */

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// index mapping
		registry.addViewController("/").setViewName("index");
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		// To convert String to views
		// success from a controller -> prefix/success + suffix
		// success from a controller -> /WEB-INF/pages/success.jsp
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	// Custome rules or beans 
	
}
