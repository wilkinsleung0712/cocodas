package com.bfd.services;

import java.util.List;

import com.bfd.model.Comment;


public interface CommentService {
	
	public List<Comment> getAllCommentByTopic(long topicId);
	
	public boolean postCommentOnTopic(Comment comment,long topicId);
	
	public boolean editCommentOnTopic(Comment comment,long topicId);
	
	public boolean deleteCommentOnTopic(long commentId, long topicId);
	
	public Comment save(Comment comment);
	

}
