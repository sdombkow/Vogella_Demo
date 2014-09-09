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
	private Key user;

	@Persistent
	private Key conversation;

	public UserConversation() {
	}

	public Key getKey() {
		return this.key;
	}

	public Key getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user.getKey();
	}

	public Key getConversation() {
		return this.conversation;
	}

	public void setConversation(Conversation convo) {
		this.conversation = convo.getKey();
	}
}