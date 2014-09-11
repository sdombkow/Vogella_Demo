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
	private Key user_group_user;

	@Persistent
	private Key user_group_group;

	public UserGroup() {
	}

	public Key getKey() {
		return key;
	}
	
	public Key getUser() {
		return this.user_group_user;
	}

	public void setUser(User user) {
		this.user_group_user = user.getKey();
	}

	public Key getGroup() {
		return this.user_group_group;
	}

	public void setGroup(Group group) {
		this.user_group_group = group.getKey();
	}
}