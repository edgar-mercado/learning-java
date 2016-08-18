package com.ecme.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecme.domain.Person;
import com.ecme.service.PersonService;

@Controller
public class PersonController {
	@Autowired
	PersonService personService;
	
	@RequestMapping(path="/savePerson", method= RequestMethod.GET)
	public String savePerson(Person p){
		Person p1 = new Person();
		p1.setName("edgar");
		p1.setAge(34);
		p1.setId(1);
		if (p!=null){
			personService.savePerson(p1);
		}
		return "index";
	}

}
