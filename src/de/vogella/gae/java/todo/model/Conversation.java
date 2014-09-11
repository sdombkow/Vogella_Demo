package de.vogella.gae.java.todo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Conversation {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

	@Persistent
	private String generated_name;

	@Persistent
	private List<Key> user_conversations;

	@Persistent
	private List<Key> replies;

	public Conversation() {
		this.generateRandomName();
		this.user_conversations = new ArrayList<Key> ();
		this.replies = new ArrayList<Key> ();
	}
	
	public Key getKey() {
		return key;
	}

	public void generateRandomName() {
		String[] array = {"Hello", "world", "DIC", "dream", "Cat", "Tom", "Heart", "Cool", "Awesome", "Dreamer"};
		Random ran = new Random();
		generated_name = array[ran.nextInt(array.length)] + " " + array[ran.nextInt(array.length)];
	}

	public String getGeneratedName() {
		return this.generated_name;
	}

	public void setGeneratedName(String name) {
		this.generated_name = name;
	}

	//methods for user conversations
	public List<Key> getUserConversations() {
		return this.user_conversations;
	}

	public void addUserConversation(UserConversation reply) {
		if(!this.user_conversations.contains(reply.getKey())){
			this.user_conversations.add(reply.getKey());
		}
	}

	public List<Key> getReplies() {
		return this.replies;
	}

	public void addReply(Reply reply) {
		if(!this.replies.contains(reply.getKey())){
			this.replies.add(reply.getKey());
		}
	}
}