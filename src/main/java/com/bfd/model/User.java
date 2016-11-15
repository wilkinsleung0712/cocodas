package com.bfd.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String firstName;
    private String lastName;

    private String username;
    private String password;

    @CreationTimestamp
    private Date registedDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Topic> listOfTopics;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Comment> listOfComments;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the registedDate
     */
    public Date getRegistedDate() {
        return registedDate;
    }

    /**
     * @param registedDate
     *            the registedDate to set
     */
    public void setRegistedDate(Date registedDate) {
        this.registedDate = registedDate;
    }

    /**
     * @return the listOfTopics
     */
    public List<Topic> getListOfTopics() {
        return listOfTopics;
    }

    /**
     * @param listOfTopics
     *            the listOfTopics to set
     */
    public void setListOfTopics(List<Topic> listOfTopics) {
        this.listOfTopics = listOfTopics;
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

}
