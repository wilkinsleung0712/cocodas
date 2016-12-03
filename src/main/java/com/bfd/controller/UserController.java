package com.bfd.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bfd.model.User;
import com.bfd.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// RequestMethod.POST
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Map<String,String> login(@RequestBody Map<String, String> userLoginDetail) throws ServletException {
		// 1.check user login detail
		if (userLoginDetail.get("username") == null || userLoginDetail.get("username").trim().isEmpty()
				|| userLoginDetail.get("password") == null || userLoginDetail.get("password").trim().isEmpty()) {
			throw new ServletException("Please fill in username and password.");
		}

		String username = userLoginDetail.get("username");
		String password = userLoginDetail.get("password");

		User user = userService.getUserByUsername(username);
		// 2.if it doest match
		if (user == null) {
			throw new ServletException("User name not found.");
		}
		// compare if the password is matched.
		if (!userService.validateUserPassowrd(password, user)) {
			throw new ServletException("User password not correct.");
		}
		// 3.if it does match send back Jwt token and the customer has to include the token header every request.
		Map<String,String> tokenJSON = new HashMap<>();
		String token = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "securetkey").compact();
		tokenJSON.put("token", token);
		return tokenJSON;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public User register(@RequestBody User user) throws ServletException {
		if (user == null) {
			throw new ServletException("Please fill in user registration form.");
		}

		return userService.addUser(user);
	}
}
