package com.bfd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bfd.dao.UserDao;
import com.bfd.model.User;
import com.bfd.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	private BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();

	@Override
	public User getUserByUsername(String username) {
		//decrpt password when finding user
		return userDao.findByUsername(username);
	}

	@Override
	public User addUser(User user) {
		// using BCrpytPassword to do encrypt password in database
		String hashedPassword = bcryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);

		return userDao.save(user);
	}

	@Override
	public boolean validateUserPassowrd(String password,User dbUser) {
		return bcryptPasswordEncoder.matches(password, dbUser.getPassword());
	}
	
	

}
