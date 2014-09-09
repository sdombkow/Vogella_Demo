package de.vogella.gae.java.todo.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class UserGroup {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent
	private Key user;

	@Persistent
	private Key group;

	public UserGroup() {
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

	public Key getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group.getKey();
	}
}