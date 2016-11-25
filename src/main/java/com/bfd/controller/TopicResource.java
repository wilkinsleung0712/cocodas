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

	// add
	@RequestMapping(value = "/topic/add", method = RequestMethod.POST)
	public Topic addTopic(@RequestBody Topic topic) {
		return topicService.save(topic);
	}
	
	//read
	@RequestMapping(value = "/topic/view/{topicId}", method = RequestMethod.GET)
	public Topic viewTopic(@PathVariable Long topicId) {
		return topicService.getTopicById(topicId);
	}

//	@RequestMapping(value = "/topic/update", method = RequestMethod.PUT)
//	public Topic updateTopic(@RequestBody Topic topic) {
//		return topicService.save(topic);
//	}


	
	@RequestMapping(value = "/topic/view/user/{username}",method=RequestMethod.GET)
	public List<Topic> getTopicsByUser(@PathVariable String username){
		return topicService.getTopicByUsername(username);
	}
	
	//update
	@RequestMapping(value="/topic/update",method=RequestMethod.POST)
	public Topic editTopic(@RequestBody Topic topic){
		return topicService.save(topic);
	}
	
	//delete
	@RequestMapping(value = "/topic/delete/{topicId}", method = RequestMethod.POST)
	public void deleteTopic(@PathVariable Long topicId) {
		topicService.deleteTopic(topicId);
	}
	
}
