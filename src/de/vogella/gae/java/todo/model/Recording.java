package de.vogella.gae.java.todo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Recording{
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

	@Persistent
	private Key recording_user;
	
	@Persistent
	private Key recording_group;
	
	@Persistent
	private List<Key> recordingLikes;

	@Persistent
	private List<Key> views;

	@Persistent
	private List<Key> comments;

	@Persistent
	private List<Key> replies;

	@Persistent
	private List<Key> tags;

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

	public Recording(Date date,String recordingFile,int seconds, boolean active, boolean available) {
		this.createDate = date;
		this.recordingFile = recordingFile;
		this.recording_length = seconds;
		this.recording_active = active;
		this.recording_public = available;
		this.recordingLikes = new ArrayList<Key>();
		this.views = new ArrayList<Key>();
		this.comments= new ArrayList<Key>();
		this.replies = new ArrayList<Key>();
		this.tags = new ArrayList<Key>();
	}

	public Key getKey() {
		return key;
	}

	public void setCreateDate(Date date) {
		this.createDate= date;
	}
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setRecordingFile(String file) {
		this.recordingFile = file;
	}

	public String getRecordingFile() {
		return this.recordingFile;
	}

	public void setRecordingLenth(int length) {
		this.recording_length = length;
	}

	public int getRecordingLength() {
		return this.recording_length;
	}
	
	public void setRecordingActive(boolean active) {
		this.recording_active = active;
	}

	public boolean getRecordingActive() {
		return this.recording_active;
	}

	public void setRecordingPublic(boolean available) {
		this.recording_public = available;
	}

	public boolean getRecordingPublic() {
		return this.recording_public;
	}
	
	//methods for users
	public Key getUser() {
		return this.recording_user;
	}
	
	public void setUser(User user) {
		this.recording_user = user.getKey();
	}
	
	//methods for groups
	public Key getGroup() {
		return this.recording_group;
	}
		
	public void setGroup(Group group) {
		this.recording_group = group.getKey();
	}
	
	//methods for likes
	public List<Key> getLikes() {
		return recordingLikes;
	}

	public void addLike(Like like) {
		if(!this.recordingLikes.contains(like.getKey())){
			this.recordingLikes.add(like.getKey());
		}
	}
	
	//methods for comments
	public List<Key> getComments() {
		return comments;
	}

	public void addComment(Comment comment) {
		if(!this.comments.contains(comment.getKey())){
			this.comments.add(comment.getKey());
		}	
	}

	//methods for views
	public List<Key> getViews() {
		return views;
	}

	public void addView(View view) {
		if(!this.views.contains(view.getKey())){
			this.views.add(view.getKey());
		}
	}

	//methods for tags
	public List<Key> getTags() {
		return tags;
	}

	public void addTag(Tag tag) {
		if(!this.tags.contains(tag.getKey())){	
		this.tags.add(tag.getKey());
		}
	}

	//methods for replies
	public List<Key> getReplies() {
		return replies;
	}

	public void addReply(Reply reply) {
		if(!this.replies.contains(reply.getKey())){
			this.replies.add(reply.getKey());
		}
	}
}