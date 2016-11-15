package com.bfd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfd.model.Topic;
import com.bfd.services.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/allTopic")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopic();
	}

}
