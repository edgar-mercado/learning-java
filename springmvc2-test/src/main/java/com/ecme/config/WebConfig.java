package com.ecme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Import({PersistenceContext.class})
@ComponentScan(value={"com.ecme.controller", "com.ecme.service.impl"})
@PropertySource("classpath:db.properties")

public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// index mapping
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/newblogpost.html").setViewName("newblogpost");
		registry.addViewController("/accessDenied").setViewName("accessDenied");
		registry.addViewController("/admin.html").setViewName("/admin/admin");
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
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigure(){
		return new PropertySourcesPlaceholderConfigurer();
		
	}

}
