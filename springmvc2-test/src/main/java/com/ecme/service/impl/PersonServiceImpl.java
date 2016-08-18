package com.ecme.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecme.dao.PersonDAO;
import com.ecme.domain.Person;
import com.ecme.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	
	@Autowired
	PersonDAO personDAO;
	
	private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

	public void savePerson(Person p) {
		log.debug("***************************** Saving: "+p.toString());
		personDAO.save(p);
	}

	public void deletePerson(Person p) {
		log.debug("Deleting: "+p.toString());
		
	}

	public Person findPersonById(long id) {
		log.debug("Finding person with id: "+id);
		return null;
	}

}
