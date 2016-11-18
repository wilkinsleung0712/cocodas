package com.bfd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bfd.model.Topic;
import com.bfd.services.TopicService;

@Controller
public class ImageUploadController {
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value="/rest/topic/update",method=RequestMethod.POST)
	public Topic editTopic(@RequestBody Topic topic){
		return topicService.save(topic);
	}
}
