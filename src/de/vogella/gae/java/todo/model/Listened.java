package de.vogella.gae.java.todo.model;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Listened {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent
	private Key user_listened;

	@Persistent
	private List<Key> user_listened_recordings;
	
	public Listened() {
		this.user_listened = null;
		this.user_listened_recordings = new ArrayList<Key>();
	}
	
	public Key getKey() {
		return key;
	}
	
	public Key getUser() {
		return this.user_listened;
	}
	
	public void setUser(User user) {
		this.user_listened = user.getKey();
	}
	
	public List<Key> getRecordings() {
		return this.user_listened_recordings;
	}

	public void addRecording(Recording recording) {
		this.user_listened_recordings.add(recording.getKey());
	}
}
