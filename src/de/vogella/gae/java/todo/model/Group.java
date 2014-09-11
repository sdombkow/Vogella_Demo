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
	private List<Key> user_groups;

	@Persistent
	private List<Key> recordings;

	public Group(String name, String description) {
		this.name= name;
		this.description= description;
		this.user_groups = new ArrayList<Key>();
		this.recordings = new ArrayList<Key>();
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

	//methods for likes
	public List<Key> getUserGroup() {
		return this.user_groups;
	}

	public void addUserGroup(UserGroup userGroup) {
		if(!this.user_groups.contains(userGroup.getKey())){
			this.user_groups.add(userGroup.getKey());
		}
	}

	public List<Key> getRecording() {
		return this.recordings;
	}

	public void addRecording(Recording recording) {
		if(!this.recordings.contains(recording.getKey())){
			this.recordings.add(recording.getKey());
		}
	}
}