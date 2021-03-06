package ecme.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ecme.spring.domain.BlogPost;
import ecme.spring.domain.DataSource;
import ecme.spring.service.BlogPostService;
import ecme.spring.service.EmailService;
import ecme.spring.service.ServiceManager;


public class MainApp {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);

	public static void main(String[] args) {
/*		ApplicationContext appContext = new AnnotationConfigApplicationContext(JavaConfig.class);
		// Call the Bean by instance type
		//BlogPostService blogPostService = appContext.getBean(BlogPostService.class);
		DataSource ds= appContext.getBean(DataSource.class);
		//LOGGER.debug("++++++++ ds: "+ds.getUrl()+":"+ds.getUsername()+":"+ds.getPsw());
		ds.setUrl("wwww.GOOOGLEEE.com");
		// Call the Bean by method name or identifier
		BlogPostService blogPostService = (BlogPostService)appContext.getBean("blogPostService");
		BlogPost bPost = new BlogPost();
		bPost.setId(1);
		bPost.setTitle("Java an Spring");
		bPost.setContent("asdfasdasdf");
		blogPostService.savePost(bPost);		
		
		EmailService es= appContext.getBean(EmailService.class);
		LOGGER.debug("++++++++ es: "+es.sendEmail("Edgar Carlos the wizard"));
		
		ServiceManager sm = appContext.getBean(ServiceManager.class);
		sm.sendBlogPost(bPost);
		
		((ConfigurableApplicationContext) appContext).close();
*/
		
		ApplicationContext apCont = new ClassPathXmlApplicationContext("application-context.xml");
		DataSource dss= apCont.getBean(DataSource.class);
		LOGGER.debug("++++++++ DS desde application-context.xml: "+dss.getUrl());
		((ConfigurableApplicationContext) apCont).close();
	}

}
