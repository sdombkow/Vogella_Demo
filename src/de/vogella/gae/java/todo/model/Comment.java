package de.vogella.gae.java.todo.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Comment {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

	@Persistent
	private String comment_text;

	@Persistent
	private Key comment_user;

	@Persistent
	private Key comment_recording;

	public Comment(String text) {
		this.comment_text= text;
	}

	public String getCommentText() {
		return this.comment_text;
	}

	public void setCommentText(String text) {
		this.comment_text= text;
	}

	public Key getKey() {
		return key;
	}

	public Key getUser() {
		return this.comment_user;
	}

	public void setUser(User user) {
		this.comment_user = user.getKey();
	}

	public Key getRecording() {
		return this.comment_recording;
	}

	public void setRecording(Recording recording) {
		this.comment_recording = recording.getKey();
	}
}