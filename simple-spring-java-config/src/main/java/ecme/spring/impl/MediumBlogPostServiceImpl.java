package ecme.spring.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecme.spring.domain.BlogPost;
import ecme.spring.service.BlogPostService;

public class MediumBlogPostServiceImpl implements BlogPostService{
	private static final Logger LOGGER = LoggerFactory.getLogger(MediumBlogPostServiceImpl.class);

	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("++++++++savePost called from MediumBlogPostServiceImpl");
		
	}


}
