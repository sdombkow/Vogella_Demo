package de.vogella.gae.java.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;

	private String commentText;

	@ManyToOne(optional = false)
	private User user;

	@ManyToOne(optional = false)
	private Recording recording;

	public Comment(String text, User user, Recording recording){
		this.commentText= text;
		this.user = user;
		this.recording = recording;
	}

	public String getCommentText(){
		return this.commentText;
	}

	public void setCommentText(String text){
		this.commentText= text;
	}

	public Key getID(){
		return id;
	}

	public User getUser(){
		return this.user;
	}

	public void setUser(User user){
		this.user = user;
		if(!user.getComments().contains(this)){
			this.user.getComments().add(this);
		}
	}

	public Recording getRecording(){
		return this.recording;
	}

	public void setRecording(Recording recording){
		this.recording = recording;
		if(!recording.getComments().contains(this)) {
			this.recording.getComments().add(this);
		}
	}
}