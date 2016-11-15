package com.bfd.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bfd.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

	User save(User user);
	
	public User findByUsername(String username);
}
