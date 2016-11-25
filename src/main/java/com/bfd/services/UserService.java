package com.bfd.services;

import com.bfd.model.User;

public interface UserService {
	public User getUserByUsername(final String username);
	
	public User addUser(final User user);
	
	public boolean validateUserPassowrd(final String password,User dbUser);
}
