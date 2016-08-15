package ecme.springmvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ecme.springmvc.domain.BlogPost;
import ecme.springmvc.domain.User;

public interface BlogPostDAO extends CrudRepository<BlogPost, Long>{
	List<BlogPost> findAllBlogPostByUserAndTitleContaining(User user, String title);
	List<BlogPost> findAllBlogPostByUserAndDraft(User user, boolean draft);
	
}
