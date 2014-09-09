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
	private String commentText;

	@Persistent
	private Key user;

	@Persistent
	private Key recording;

	public Comment(String text) {
		this.commentText= text;
	}

	public String getCommentText() {
		return this.commentText;
	}

	public void setCommentText(String text) {
		this.commentText= text;
	}

	public Key getKey() {
		return key;
	}

	public Key getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user.getKey();
	}

	public Key getRecording() {
		return this.recording;
	}

	public void setRecording(Recording recording) {
		this.recording = recording.getKey();
	}
}