package ecme.springmvc.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ecme.springmvc.domain.BlogPost;
import ecme.springmvc.domain.User;
import ecme.springmvc.service.BlogPostService;
import ecme.springmvc.service.UserService;

@Controller
public class BlogPostController {
	
	@Autowired
	private BlogPostService blogPostService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@RequestMapping(value="/saveBlogPost",  method = RequestMethod.POST)
	public ModelAndView saveBlogPost(
			@RequestParam(value="title")  String title,
			@RequestParam(value="content")  String content,
			@RequestParam(value="draft", required=false)  boolean draft, Locale locale
			){
		BlogPost bp= new BlogPost();
		bp.setTitle(title);
		bp.setContent(content);
		bp.setUser(userService.findByUserId(1L));
		
		if (draft)
			blogPostService.savePostAsDraft(bp);
		else{		
			bp.setPublishDate(new Date());
			blogPostService.savePostAsDraft(bp);
		}
		return new ModelAndView("newblogpost", "message", messageSource.getMessage("blogpost.save", null, locale));
	}
	@RequestMapping(value="/blogposts",  method = RequestMethod.GET)
	public ModelAndView blogPosts(){
		User user = userService.findByUserId(1L);
		List<BlogPost> 	blogPost = user.getBlogPosts();
		return new ModelAndView("blogposts","blogposts", blogPost);
	}
	@RequestMapping(value="/draftBlogposts",  method = RequestMethod.GET)
	public ModelAndView draftBlogposts(){
		User user = userService.findByUserId(1L);
		List<BlogPost> 	blogPost = blogPostService.listAllBlogPostByUserAndDraftStatus(user, true);
		return new ModelAndView("blogposts","blogposts", blogPost);
	}
	@RequestMapping(value="/searchByTitle",  method = RequestMethod.POST)
	public ModelAndView searchByTitle(@RequestParam (value="title") String title){
		User user = userService.findByUserId(1L);
		List<BlogPost> 	blogPost = blogPostService.listAllBlogPostByUserAndTitleLike(user, title);
		return new ModelAndView("blogposts","blogposts", blogPost);
	}
	@RequestMapping(value="/getBlogPostById/{id}",  method = RequestMethod.GET)
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody BlogPost getBlogPostById(@PathVariable(value="id") long id ){
		return blogPostService.findBlogPostById(id);
	}
}
