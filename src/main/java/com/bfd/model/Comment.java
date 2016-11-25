package com.bfd.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long commentId;
    
    private String commentDetail;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private Topic topic;
    
    private Long topicId;
    
    private String username;
    
    @CreationTimestamp
    private Date commentDate;

    
    public Comment() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the commentId
     */
    public long getCommentId() {
        return commentId;
    }

    /**
     * @param commentId the commentId to set
     */
    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    /**
     * @return the commentDetail
     */
    public String getCommentDetail() {
        return commentDetail;
    }

    /**
     * @param commentDetail the commentDetail to set
     */
    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the topic
     */
    public Topic getTopic() {
        return topic;
    }

    /**
     * @param topic the topic to set
     */
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    /**
     * @return the commentDate
     */
    public Date getCommentDate() {
        return commentDate;
    }

    /**
     * @param commentDate the commentDate to set
     */
    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
    
}
