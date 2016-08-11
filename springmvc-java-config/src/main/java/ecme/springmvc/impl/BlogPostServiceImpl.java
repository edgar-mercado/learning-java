package ecme.springmvc.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ecme.springmvc.domain.BlogPost;
import ecme.springmvc.domain.DataSource;
import ecme.springmvc.service.BlogPostService;

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
