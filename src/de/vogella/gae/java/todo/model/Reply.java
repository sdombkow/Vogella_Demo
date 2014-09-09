package de.vogella.gae.java.todo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;

	private Date create_date;
	
	@ManyToOne(optional = false)
	private User user;

	@ManyToOne(optional = false)
	private Recording recording;
	
	@ManyToOne(optional = false)
	private Conversation conversation;
	
	public Reply(Date create_date, Conversation conversation, User user, Recording recording) {
		this.create_date = create_date;
		this.conversation= conversation;
		this.user = user;
		this.recording =recording;
	}
	
	public Key getID(){
		return id;
	}

	public Date getCreateDate(){
		return this.create_date;
	}
	
	public void setCreateDate(Date date){
		this.create_date = date;
	}
	
	public Conversation getConversation(){
		return this.conversation;
	}
	
	public void setConversation(Conversation convo){
		this.conversation = convo;
		if(!conversation.getReplies().contains(this)){
			this.conversation.getReplies().add(this);
		
		}
	}

	public User getUser(){
		return this.user;
	}
	
	public void setUser(User user){
		this.user = user;
		if(!user.getReplies().contains(this)){
			this.user.getReplies().add(this);
		}
	}

	public Recording getRecording(){
		return this.recording;
	}

	public void setRecording(Recording recording){
		this.recording = recording;
		if(!recording.getReplies().contains(this)){
			this.recording.getReplies().add(this);
		
		}
	}
}