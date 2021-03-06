package ecme.spring.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ecme.spring.service.EmailService;

public class EmailServiceImp implements EmailService{
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImp.class);

	@Override
	public String sendEmail(String msg) {
		LOGGER.debug(">>>> mail sent <<<<");
		return " to:"+msg;
		
	}

}
