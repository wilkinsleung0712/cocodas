package com.bfd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bfd.model.Comment;
import com.bfd.model.Topic;
import com.bfd.model.User;
import com.bfd.services.CommentService;
import com.bfd.services.TopicService;
import com.bfd.services.UserService;

@RestController
@RequestMapping("/rest/comment")
public class CommentResrouce {
	@Autowired
	private CommentService commentService;

	@Autowired
	private TopicService topicService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{topicId}", method = RequestMethod.GET)
	public List<Comment> getCommentsByTopicId(@PathVariable long topicId) {
		return commentService.getAllCommentByTopic(topicId);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void postCommentOnTopic(@RequestBody Comment comment) {
		if (comment != null && comment.getTopicId() != null && comment.getUsername() != null
				&& !comment.getUsername().isEmpty()) {
			Topic topic = topicService.getTopicById(comment.getTopicId());
			User user = userService.getUserByUsername(comment.getUsername());

			if (topic == null || user == null) {
				System.out.println("warning: unable to find topic to post comment");
			} else {
				comment.setTopic(topic);
				comment.setUser(user);
				this.commentService.save(comment);
			}

		}

	}
}