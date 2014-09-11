package de.vogella.gae.java.todo.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class View {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent
	private Key view_user;

	@Persistent
	private Key view_recording;
	
	public View() {
	}

	public Key getKey() {
		return key;
	}

	public Key getUser() {
		return this.view_user;
	}
	
	public void setUser(User user) {
		this.view_user = user.getKey();
	}

	public Key getRecording() {
		return this.view_recording;
	}

	public void setRecording(Recording recording) {
		this.view_recording = recording.getKey();
	}
}