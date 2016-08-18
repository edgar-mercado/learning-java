package com.ecme.service;

import com.ecme.domain.Person;

public interface PersonService {
	void savePerson(Person p);
	void deletePerson(Person p);
	Person findPersonById(long id);
}
