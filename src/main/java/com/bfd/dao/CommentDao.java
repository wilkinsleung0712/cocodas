package com.bfd.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bfd.model.Comment;
import com.bfd.model.Topic;
import com.bfd.model.User;

@Repository
public interface CommentDao extends CrudRepository<Comment, Long>{

	public Comment save(Comment comment);
	
	public void findCommentByUserAndTopic(User user, Topic topic);
}
