package com.bfd.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bfd.model.Topic;

@Repository
public interface TopicDao extends CrudRepository<Topic, Long>{

	public Topic save(Topic topic);
	
	public Topic findByTopicTitle(String topicTitle);
	
	public Topic findByTopicId(Long topicId);
	
	public List<Topic> findAll();
	
	public List<Topic> findByUsername(String username);
	
}

