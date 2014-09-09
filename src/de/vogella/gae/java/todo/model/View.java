package de.vogella.gae.java.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

@Entity
public class View {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;
	
	@ManyToOne(optional = false)
	private User user;

	@ManyToOne(optional = false)
	private Recording recording;
	
	public View(User user, Recording recording) {
		this.user = user;
		this.recording = recording;
	}

	public Key getID(){
		return id;
	}

	public User getUser(){
		return this.user;
	}
	
	public void setUser(User user){
		this.user = user;
		if(!user.getViews().contains(this)){
			this.user.getViews().add(this);
		}
	}

	public Recording getRecording(){
		return this.recording;
	}

	public void setRecording(Recording recording){
		this.recording = recording;
		if(!recording.getViews().contains(this)){
			this.recording.getViews().add(this);
		}
	}
}