package ecme.springmvc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecme.springmvc.dao.UserDAO;
import ecme.springmvc.domain.User;
import ecme.springmvc.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public User findByUserId(long id) {
		User usr = userDAO.findOne(id);
		return usr;
	}

	@Override
	public User findUserWithBlogPostByUsername(String username) {
		
		return userDAO.findUserByUsername(username);
	}

}
