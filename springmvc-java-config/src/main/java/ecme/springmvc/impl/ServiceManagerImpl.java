package ecme.springmvc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ecme.springmvc.domain.BlogPost;
import ecme.springmvc.service.BlogPostService;
import ecme.springmvc.service.ServiceManager;

public class ServiceManagerImpl implements ServiceManager{

	@Autowired
	@Qualifier("MediumBlogPostService")
	private BlogPostService blogPostService;
	
	@Override
	public void sendBlogPost(BlogPost blogPost) {
		blogPostService.savePost(blogPost);
		
	}

}
