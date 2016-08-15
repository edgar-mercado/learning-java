package ecme.springmvc.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecme.springmvc.dao.BlogPostDAO;
import ecme.springmvc.domain.BlogPost;
import ecme.springmvc.domain.DataSource;
import ecme.springmvc.domain.User;
import ecme.springmvc.service.BlogPostService;

@Service
public class BlogPostServiceImpl implements BlogPostService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);
	
	@Autowired
	BlogPostDAO blogPostDAO;

	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("BlogPostServiceImpl: save is called");
		blogPost.setPublishDate(new Date());
		blogPostDAO.save(blogPost);
	}

	@Override
	public void savePostAsDraft(BlogPost blogPost) {
		blogPost.setDraft(true);
		blogPostDAO.save(blogPost);
		
	}

	@Override
	public void deletePost(BlogPost blogPost) {
		blogPostDAO.delete(blogPost);
		
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft) {
		return blogPostDAO.findAllBlogPostByUserAndDraft(user, draft);
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title) {
		return blogPostDAO.findAllBlogPostByUserAndTitleContaining(user, title);
	}

	@Override
	public BlogPost findBlogPostById(long id) {
		// TODO Auto-generated method stub
		return blogPostDAO.findOne(id	);
	}

}
