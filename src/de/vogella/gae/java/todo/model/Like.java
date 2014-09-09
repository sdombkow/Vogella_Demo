package de.vogella.gae.java.todo.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Like {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	private String comment;

	@Persistent
	private Key user;
	
	@Persistent
	private Key recording;

	public Like(String text) {
		this.comment = text;
	}

	public Key getKey(){
		return key;
	}

	public String getComment(){
		return comment;
	}

	public void setComment(String text){
		this.comment = text;
	}
	
	public Key getUser(){
		return this.user;
	}
	
	public void setUser(User user){
		this.user = user.getKey();
	}

	public Key getRecording(){
		return this.recording;
	}

	public void setRecording(Recording recording){
		this.recording = recording.getKey();
	}
}