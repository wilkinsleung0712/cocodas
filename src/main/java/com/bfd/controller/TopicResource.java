package com.bfd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bfd.model.Topic;
import com.bfd.services.TopicService;

@RestController
@RequestMapping("/rest")
public class TopicResource {

	@Autowired
	private TopicService topicService;

	@RequestMapping(value = "/topic/add", method = RequestMethod.POST)
	public Topic addTopic(@RequestBody Topic topic) {
		return topicService.save(topic);
	}

	@RequestMapping(value = "/topic/view/{topicId}", method = RequestMethod.POST)
	public Topic viewTopic(@PathVariable Long topicId) {
		return topicService.getTopicById(topicId);
	}

	@RequestMapping(value = "/topic/update", method = RequestMethod.POST)
	public Topic updateTopic(@RequestBody Topic topic) {
		return topicService.save(topic);
	}

	@RequestMapping(value = "/topic/delete/{topicId}", method = RequestMethod.POST)
	public void deleteTopic(@PathVariable Long topicId) {
		topicService.deleteTopic(topicId);
	}
	
	@RequestMapping(value = "/topic/view/user/{userId}",method=RequestMethod.GET)
	public List<Topic> getTopicsByUser(@PathVariable Long userId){
		return topicService.getTopicByUserId(userId);
	}
}
