package com.bfd.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestBody Map<String,String> json){
		System.out.println(json);
		return "This is login";
	}
}
