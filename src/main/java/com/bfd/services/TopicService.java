package com.bfd.services;

import java.util.List;

import com.bfd.model.Topic;
import com.bfd.model.User;

public interface TopicService {
	
	public Topic save(Topic topic);
	
	public List<Topic> getAllTopic();
	
	public Topic getTopicById(Long topicId);
	
	public Topic updateTopic(Topic topic);

	public void deleteTopic(Long topicId);
	
	public List<Topic> getTopicByUserId(Long userId);
}
