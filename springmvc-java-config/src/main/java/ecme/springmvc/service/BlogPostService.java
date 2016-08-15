package ecme.springmvc.service;

import java.util.List;

import ecme.springmvc.domain.BlogPost;
import ecme.springmvc.domain.User;

public interface BlogPostService {
	void savePost(BlogPost blogPost);
	void savePostAsDraft(BlogPost blogPost);
	void deletePost(BlogPost blogPost);
	List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft);
	List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title);
	BlogPost findBlogPostById(long id);
}
