package com.bfd.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long topicId;

	private String topicTitle;
	private String topicDescription;

	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Comment> listOfComments;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "userId")
	private User user;

	private String username;

	private int likedVote;

	@Transient // Hibernate will ignore and wont create a field
	private MultipartFile topicImage;

	@CreationTimestamp
	private Date createdDate;

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the topicId
	 */
	public long getTopicId() {
		return topicId;
	}

	/**
	 * @param topicId
	 *            the topicId to set
	 */
	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	/**
	 * @return the topicTitle
	 */
	public String getTopicTitle() {
		return topicTitle;
	}

	/**
	 * @param topicTitle
	 *            the topicTitle to set
	 */
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	/**
	 * @return the topicDescription
	 */
	public String getTopicDescription() {
		return topicDescription;
	}

	/**
	 * @param topicDescription
	 *            the topicDescription to set
	 */
	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	/**
	 * @return the listOfComments
	 */
	public List<Comment> getListOfComments() {
		return listOfComments;
	}

	/**
	 * @param listOfComments
	 *            the listOfComments to set
	 */
	public void setListOfComments(List<Comment> listOfComments) {
		this.listOfComments = listOfComments;
	}

	/**
	 * @return the likedVote
	 */
	public int getLikedVote() {
		return likedVote;
	}

	/**
	 * @param likedVote
	 *            the likedVote to set
	 */
	public void setLikedVote(int likedVote) {
		this.likedVote = likedVote;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public MultipartFile getProductImage() {
		return topicImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.topicImage = productImage;
	}

	// custom method
	public Comment getCommentByCommentId(long commentId) {
		for (Comment comment : listOfComments) {
			if (comment.getCommentId() == commentId) {
				return comment;
			}
		}
		// this should not be happening
		// log a error message
		System.out
				.println("warning: trying to find comment that is not in the topic -> " + topicId + " ->" + commentId);
		return null;
	}

}
