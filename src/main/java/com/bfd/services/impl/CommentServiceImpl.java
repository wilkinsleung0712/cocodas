package com.bfd.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfd.dao.CommentDao;
import com.bfd.dao.TopicDao;
import com.bfd.model.Comment;
import com.bfd.model.Topic;
import com.bfd.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private TopicDao topicDao;

	@Override
	public List<Comment> getAllCommentByTopic(long topicId) {
		return (List<Comment>) commentDao.findByTopicId(topicId);
	}

	@Override
	public boolean postCommentOnTopic(Comment comment, long topicId) {
		Topic topic = null;
		try {
			topic = topicDao.findByTopicId(topicId);
			topic.getListOfComments().add(comment);
			comment.setTopic(topic);

			topicDao.save(topic);
			commentDao.save(comment);
			return true;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		return false;
	}

	@Override
	public boolean editCommentOnTopic(Comment comment, long topicId) {
		Topic topic = null;
		Long commentId = null;
		Comment currentComment = null;
		try {
			topic = topicDao.findByTopicId(topicId);
			commentId = comment.getCommentId();
			currentComment = topic.getCommentByCommentId(commentId);
			String newCommentDetail = comment.getCommentDetail();
			if (newCommentDetail != null && !newCommentDetail.isEmpty()) {
				currentComment.setCommentDetail(newCommentDetail);
				return true;
			}

		} catch (Exception ex) {
			System.out.println("warning: unable to edit comment on topic ->" + topicId);
		}
		return false;
	}

	@Override
	public boolean deleteCommentOnTopic(long commentId, long topicId) {
		try {
			this.commentDao.delete(commentId);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public Comment save(Comment comment) {
		return this.commentDao.save(comment);
	}

}
