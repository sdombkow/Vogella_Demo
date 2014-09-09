package de.vogella.gae.java.todo.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Tag {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent
	private String tagText;

	@Persistent
	private Key recording;

	
	public Tag(String text) {
		this.tagText = text;
	}
	
	public Key getKey() {
		return key;
	}

	public String getTagText() {
		return this.tagText;
	}

	public void setTagText(String text) {
		this.tagText = text;
	}

	public Key getRecording() {
		return this.recording;
	}

	public void setRecording(Recording recording) {
		this.recording = recording.getKey();
	}
}