package de.vogella.gae.java.todo.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class UserConversation {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

	@Persistent
	private Key user_conversation_user;

	@Persistent
	private Key user_conversation_conversation;

	public UserConversation() {
	}

	public Key getKey() {
		return this.key;
	}

	public Key getUser() {
		return this.user_conversation_user;
	}

	public void setUser(User user) {
		this.user_conversation_user = user.getKey();
	}

	public Key getConversation() {
		return this.user_conversation_conversation;
	}

	public void setConversation(Conversation convo) {
		this.user_conversation_conversation = convo.getKey();
	}
}