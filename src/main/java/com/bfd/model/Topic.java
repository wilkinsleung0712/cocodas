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

import org.hibernate.annotations.CreationTimestamp;

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
    @JoinColumn(name="userId")
    private User user;

    private int likedVote;

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

}
