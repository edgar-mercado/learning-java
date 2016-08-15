package ecme.springmvc.dao;

import org.springframework.data.repository.CrudRepository;

import ecme.springmvc.domain.User;

public interface UserDAO extends CrudRepository<User, Long>{
	User findUserByUsername(String username);
	
}
