package ecme.springmvc.service;

import ecme.springmvc.domain.User;

public interface UserService {
	User findByUserId(long id);
	User findUserWithBlogPostByUsername(String username);
}
