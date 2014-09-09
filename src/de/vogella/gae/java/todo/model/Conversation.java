package de.vogella.gae.java.todo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@Entity
public class Conversation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;

	private String generatedName;

	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "user")
	private List<UserConversation> userConversations;

	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "user")
	private List<Reply> replies;

	public Conversation(){
		this.generateRandomName();
		this.userConversations = new ArrayList<UserConversation> ();
		this.replies = new ArrayList<Reply> ();
	}
	
	public Key getID(){
		return id;
	}

	public void generateRandomName(){
		String[] array = {"Hello", "world", "DIC", "dream", "Cat", "Tom", "Heart", "Cool", "Awesome", "Dreamer"};
		Random ran = new Random();
		generatedName = array[ran.nextInt(array.length)] + " " + array[ran.nextInt(array.length)];
	}

	public String getGeneratedName(){
		return this.generatedName;
	}

	public void setGeneratedName(String name){
		this.generatedName = name;
	}

	//methods for user conversations
	public List<UserConversation> getUserConversations(){
		return this.userConversations;
	}

	public void addUserConversation(UserConversation reply) {
		if(!this.userConversations.contains(reply)){
			this.userConversations.add(reply);
			if(reply.getConversation() != this){
				reply.setConversation(this);
			}
		}
	}

	public List<Reply> getReplies(){
		return this.replies;
	}

	public void addReply(Reply reply) {
		if(!this.replies.contains(reply)){
			this.replies.add(reply);
			if(reply.getConversation() != this){
				reply.setConversation(this);
			}
		}
	}
}