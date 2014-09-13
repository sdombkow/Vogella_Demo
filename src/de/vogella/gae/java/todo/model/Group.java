package de.vogella.gae.java.todo.model;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Group {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent
	private String name;
	
	@Persistent
	private String description;

	@Persistent
	private List<Key> group_users;

	@Persistent
	private List<Key> group_recordings;

	public Group(String name, String description) {
		this.name= name;
		this.description= description;
		this.group_users = new ArrayList<Key>();
		this.group_recordings = new ArrayList<Key>();
	}
	
	public Key getKey() {
		return this.key;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Key> getUsers() {
		return this.group_users;
	}

	public void addUser(User user) {
		if(!this.group_users.contains(user.getKey())){
			this.group_users.add(user.getKey());
		}
	}

	public List<Key> getRecording() {
		return this.group_recordings;
	}

	public void addRecording(Recording recording) {
		if(!this.group_recordings.contains(recording.getKey())){
			this.group_recordings.add(recording.getKey());
		}
	}
}