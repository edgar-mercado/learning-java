package ecme.spring.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ecme.spring.domain.BlogPost;
import ecme.spring.domain.DataSource;
import ecme.spring.service.BlogPostService;

public class BlogPostServiceImpl implements BlogPostService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);
	
	@Autowired
	DataSource ds;

	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("------->><<Connecting to "+ ds.getUrl() +" to save the post");
		LOGGER.debug("BlogPostServiceImpl: save is called");
	}

}
