package de.vogella.gae.java.todo.model;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Reply {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

	@Persistent
	private Date create_date;
	
	@Persistent
	private Key reply_user;

	@Persistent
	private Key reply_recording;
	
	@Persistent
	private Key reply_conversation;
	
	public Reply(Date create_date) {
		this.create_date = create_date;
	}
	
	public Key getKey() {
		return key;
	}

	public Date getCreateDate() {
		return this.create_date;
	}
	
	public void setCreateDate(Date date) {
		this.create_date = date;
	}
	
	public Key getConversation() {
		return this.reply_conversation;
	}
	
	public void setConversation(Conversation convo) {
		this.reply_conversation = convo.getKey();
	}

	public Key getUser() {
		return this.reply_user;
	}
	
	public void setUser(User user) {
		this.reply_user = user.getKey();
	}

	public Key getRecording() {
		return this.reply_recording;
	}

	public void setRecording(Recording recording) {
		this.reply_recording = recording.getKey();
	}
}