package ecme.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ecme.spring.domain.BlogPost;
import ecme.spring.service.BlogPostService;
import ecme.spring.service.ServiceManager;

public class ServiceManagerImpl implements ServiceManager{

	@Autowired
	@Qualifier("MediumBlogPostService")
	private BlogPostService blogPostService;
	
	@Override
	public void sendBlogPost(BlogPost blogPost) {
		blogPostService.savePost(blogPost);
		
	}

}
