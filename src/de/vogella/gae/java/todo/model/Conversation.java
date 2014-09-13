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
	private List<Key> conversation_users;

	@Persistent
	private List<Key> conversation_replies;
	
	@Persistent
	private List<String> conversation_generated_names;

	public Conversation() {
		this.conversation_generated_names = new ArrayList<String>();
		this.conversation_users = new ArrayList<Key>();
		this.conversation_replies = new ArrayList<Key>();
	}
	
	public Key getKey() {
		return key;
	}

	public String generateRandomName() {
		String[] array = {"Hello", "world", "DIC", "dream", "Cat", "Tom", "Heart", "Cool", "Awesome", "Dreamer"};
		Random ran = new Random();
		String generated_name = array[ran.nextInt(array.length)] + " " + array[ran.nextInt(array.length)];
		return generated_name;
	}

	public List<String> getGeneratedNames() {
		return this.conversation_generated_names;
	}

	public void addGeneratedName(String name) {
		this.conversation_generated_names.add(name);
	}

	//methods for user conversations
	public List<Key> getUsers() {
		return this.conversation_users;
	}

	public void addUser(User user) {
		if(!this.conversation_users.contains(user.getKey())){
			this.conversation_users.add(user.getKey());
			this.addGeneratedName(generateRandomName());
		}
	}

	public List<Key> getReplies() {
		return this.conversation_replies;
	}

	public void addReply(Reply reply) {
		if(!this.conversation_replies.contains(reply.getKey())){
			this.conversation_replies.add(reply.getKey());
		}
	}
}