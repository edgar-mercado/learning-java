package ecme.springmvc.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecme.springmvc.domain.BlogPost;
import ecme.springmvc.service.BlogPostService;

public class WordpressBlogServiceImpl implements BlogPostService{
	private static final Logger LOGGER = LoggerFactory.getLogger(WordpressBlogServiceImpl.class);

	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("++++++++savePost called from WordpressBlogServiceImpl");
		
	}

}