package de.vogella.gae.java.todo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Recording{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

	@Persistent
	private Key user;
	
	@Persistent(mappedBy = "recording")
	private List<Key> likes;
	
	/*
	@OneToMany
	private List<Like> likes;

	@OneToMany
	private List<View> views;

	@OneToMany
	private List<Comment> comments;

	@OneToMany
	private List<Reply> replies;

	@OneToMany(cascade = {CascadeType.ALL})
	private List<Tag> tags;
	*/

	@Persistent	
	private Date createDate;
	
	@Persistent
	private String recordingFile;
	
	@Persistent
	private int recording_length;
	
	@Persistent
	private boolean recording_active;
	
	@Persistent
	private boolean recording_public;

	public Recording(Date date,String recordingFile,int seconds, boolean active, boolean available){
		this.createDate = date;
		this.recordingFile = recordingFile;
		this.recording_length = seconds;
		this.recording_active = active;
		this.recording_public = available;
		this.likes = new ArrayList<Key>();
		/*
		this.views = new ArrayList<View>();
		this.comments= new ArrayList<Comment>();
		this.replies = new ArrayList<Reply>();
		this.tags = new ArrayList<Tag>();
		*/
	}

	public Key getKey(){
		return key;
	}

	public void setCreateDate(Date date){
		this.createDate= date;
	}
	public Date getCreateDate(){
		return this.createDate;
	}

	public void setRecordingFile(String file){
		this.recordingFile = file;
	}

	public String getRecordingFile(){
		return this.recordingFile;
	}

	public void setRecordingLenth(int length){
		this.recording_length = length;
	}

	public int getRecordingLength(){
		return this.recording_length;
	}
	
	public void setRecordingActive(boolean active){
		this.recording_active = active;
	}

	public boolean getRecordingActive(){
		return this.recording_active;
	}

	public void setRecordingPublic(boolean available){
		this.recording_public = available;
	}

	public boolean getRecordingPublic(){
		return this.recording_public;
	}
	
	public Key getUser(){
		return this.user;
	}
	
	public void setUser(User user){
		this.user = user.getKey();
	}
	
	//methods for likes
	public List<Key> getLikes(){
		return likes;
	}

	public void addLike(Like like) {
		if(!this.likes.contains(like.getKey())){
			this.likes.add(like.getKey());
		}
	}
	
	/*
	//methods for comments
	public List<Comment> getComments(){
		return comments;
	}

	public void addComment(Comment comment) {
		if(!this.comments.contains(comment)){
			this.comments.add(comment);
			if(comment.getRecording() != this){
				comment.setRecording(this);
			}
		}	
	}

	//methods for views
	public List<View> getViews(){
		return views;
	}

	public void addView(View view) {
		if(!this.views.contains(view)){
			this.views.add(view);
			if(view.getRecording() != this){
				view.setRecording(this);
			}
		}
	}

	//methods for tags
	public List<View> getTags(){
		return tags;
	}

	public void addTag(Tag tag) {
		if(!this.tags.contains(tag)){	
		this.tags.add(tag);
			if(tag.getRecording() != this){
				tag.setRecording(this);
			}
		}
	}

	//methods for replies
	public List<Reply> getReplies(){
		return replies;
	}

	public void addReply(Reply reply) {
		if(!this.replies.contains(reply)){
			this.replies.add(reply);
			if(reply.getRecording() != this){
				reply.setRecording(this);
			}
		}
	}

	public User getUser(){
		return this.user;
	}
	
	public void setUser(User user){
		this.user = user;
		if(!user.getRecordings().contains(this)){
			this.user.getRecordings().add(this);
		}
	}
	*/
}