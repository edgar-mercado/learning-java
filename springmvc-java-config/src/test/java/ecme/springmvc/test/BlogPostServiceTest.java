package ecme.springmvc.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import ecme.springmvc.config.WebConfig;
import ecme.springmvc.domain.BlogPost;
import ecme.springmvc.domain.User;
import ecme.springmvc.service.BlogPostService;
import ecme.springmvc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={WebConfig.class}, loader= AnnotationConfigWebContextLoader.class)
public class BlogPostServiceTest {
	
	@Autowired
	private  BlogPostService blogPostService;

	@Autowired
	private UserService userService;
		
	@Test
	public void testBlogPostService() {
		BlogPost blogPost = new BlogPost();
		blogPost.setTitle("prueba");
		blogPost.setContent("asdfasdfasdfsafds dfs dfsa sdf");
		blogPost.setDraft(true);
		User usr=userService.findByUserId(1L);
		assertNotNull(usr);
		blogPost.setUser(usr);
		blogPostService.savePost(blogPost);
		blogPostService.deletePost(blogPost);
		assertTrue(blogPostService.listAllBlogPostByUserAndTitleLike(usr, "prueba").size()==0);
	}

}
