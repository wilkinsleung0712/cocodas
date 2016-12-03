package com.bfd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bfd.model.Comment;
import com.bfd.model.Topic;
import com.bfd.services.CommentService;
import com.bfd.services.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private TopicService topicService;

	@RequestMapping("/allTopic")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopic();
	}

	@RequestMapping(value = "/{topicId}/comments", method = RequestMethod.GET)
	public List<Comment> getCommentsByTopicId(@PathVariable long topicId) {
		return commentService.getAllCommentByTopic(topicId);
	}

	//read
	@RequestMapping(value = "/view/{topicId}", method = RequestMethod.GET)
	public Topic viewTopic(@PathVariable Long topicId) {
		return topicService.getTopicById(topicId);
	}
}
