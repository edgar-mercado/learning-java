package ecme.springmvc.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecme.springmvc.domain.BlogPost;
import ecme.springmvc.domain.User;
import ecme.springmvc.service.BlogPostService;

public class MediumBlogPostServiceImpl implements BlogPostService{
	private static final Logger LOGGER = LoggerFactory.getLogger(MediumBlogPostServiceImpl.class);

	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("++++++++savePost called from MediumBlogPostServiceImpl");
		
	}

	@Override
	public void savePostAsDraft(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePost(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogPost findBlogPostById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
