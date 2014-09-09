package de.vogella.gae.java.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

@Entity
public class UserConversation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;

	@ManyToOne(optional = false)
	private User user;

	@ManyToOne(optional = false)
	private Conversation conversation;

	public UserConversation(User user, Conversation conversation){
		this.user = user;
		this.conversation = conversation;
	}

	public Key getID(){
		return this.id;
	}

	public User getUser(){
		return this.user;
	}

	public void setUser(User user){
		this.user = user;
		if(!user.getUserConversations().contains(this)){
			this.user.getUserConversations().add(this);
		}
	}

	public Conversation getConversation(){
		return this.conversation;
	}

	public void setConversation(Conversation convo){
		this.conversation = convo;
		if(!conversation.getUserConversations().contains(this)){
			this.conversation.getUserConversations().add(this);
		}
	}
}