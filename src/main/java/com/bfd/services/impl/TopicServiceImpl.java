package com.bfd.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfd.dao.TopicDao;
import com.bfd.model.Topic;
import com.bfd.model.User;
import com.bfd.services.TopicService;

@Service
public class TopicServiceImpl implements TopicService{

	@Autowired
	private TopicDao topicDao;
	
	@Override	
	public List<Topic> getAllTopic() {
		return topicDao.findAll();
	}

	@Override
	public Topic save(Topic topic) {
		return topicDao.save(topic);
	}

	@Override
	public Topic getTopicById(Long topicId) {
		return topicDao.findByTopicId(topicId);
	}

	@Override
	public Topic updateTopic(Topic topic) {
		return topicDao.save(topic);
	}

	@Override
	public void deleteTopic(Long topicId) {
		topicDao.delete(topicId);
	}

	@Override
	public List<Topic> getTopicByUsername(String username) {
		return topicDao.findByUsername(username);
	}

}
