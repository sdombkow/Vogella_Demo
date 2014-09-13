package de.vogella.gae.java.todo.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Like {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent
	private String comment;

	@Persistent
	private Key like_user;
	
	@Persistent
	private Key liked_recording;

	public Like(String text) {
		this.comment = text;
	}

	public Key getKey() {
		return key;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String text) {
		this.comment = text;
	}
	
	public Key getUser() {
		return this.like_user;
	}
	
	public void setUser(User user) {
		this.like_user = user.getKey();
	}

	public Key getRecording() {
		return this.liked_recording;
	}

	public void setRecording(Recording recording) {
		this.liked_recording = recording.getKey();
	}
}