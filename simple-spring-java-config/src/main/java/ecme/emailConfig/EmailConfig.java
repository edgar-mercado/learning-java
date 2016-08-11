package ecme.emailConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ecme.spring.impl.EmailServiceImp;
import ecme.spring.service.EmailService;

@Configuration
public class EmailConfig {

	@Bean
	public EmailService getEmailService(){
		return new EmailServiceImp();
	}
}
