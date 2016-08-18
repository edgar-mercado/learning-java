package com.ecme.dao;

import org.springframework.data.repository.CrudRepository;

import com.ecme.domain.Person;

public interface PersonDAO extends CrudRepository<Person, Long>{
	Person findPersonById(long id);
}
