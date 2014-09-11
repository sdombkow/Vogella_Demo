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
public class User {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent
    private List<Key> userRecordings;

	@Persistent
    private List<Key> groups;
	
	@Persistent
	private List<Key> userLikes;
	
	@Persistent
	private List<Key> comments;

	@Persistent
	private List<Key> views;

	@Persistent
	private List<Key> replies;

	@Persistent
	private List<Key> userConversations;

	@Persistent
	private String phone_number;
	
	@Persistent
	private String primary_email_address;
	
	@Persistent
	private String password;
	
	@Persistent
	private Date create_date;

	public User(String phone_number, String primary_email_address, String password, Date date) {
		this.phone_number= phone_number;
		this.primary_email_address= primary_email_address;
		this.password = password;
		this.create_date = date;
		this.userRecordings = new ArrayList<Key>();
		this.groups = new ArrayList<Key>();
		this.userLikes = new ArrayList<Key>();
		this.comments = new ArrayList<Key>();
		this.views = new ArrayList<Key>();
		this.replies = new ArrayList<Key>();
		this.userConversations = new ArrayList<Key>();
	}

	public Key getKey() {
		return key;
	}

	public String getPhoneNumber() {
		return phone_number;
	}

	public void setPhoneNumer(String number) {
		this.phone_number = number;
	}

	public String getPrimaryEmail_address() {
		return primary_email_address;
	}

	public void setPrimaryEmailAddress(String email) {
		this.primary_email_address = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return create_date;
	}

	public void setCreateDate(Date date) {
		this.create_date = date;
	}
	
	//methods for recordings
	public List<Key> getRecordings() {
		return userRecordings;
	}

	public void addRecording(Recording recording) {
		if(!this.userRecordings.contains(recording.getKey())){
			this.userRecordings.add(recording.getKey());
		}		
	}
	
	//methods for groups
	public List<Key> getGroups() {
		return groups;
	}

	public void addGroup(Group group) {
		if(!this.groups.contains(group.getKey())){
			this.groups.add(group.getKey());
		}		
	}

	//methods for likes
	public List<Key> getLikes(){
		return userLikes;
	}

	public void addLike(Like like) {
		if(!this.userLikes.contains(like.getKey())){
			this.userLikes.add(like.getKey());
		}
	}

	//methods for comments
	public List<Key> getComments(){
		return comments;
	}

	public void addComment(Comment comment) {
		if(!this.comments.contains(comment.getKey())){
			this.comments.add(comment.getKey());
		}
	}

	//methods for view
	public List<Key> getViews(){
		return views;
	}

	public void addView(View view) {
		if(!this.views.contains(view.getKey())){
			this.views.add(view.getKey());
		}
	}

	//methods for replies
	public List<Key> getReplies(){
		return replies;
	}

	public void addReply(Reply reply) {
		if(!this.replies.contains(reply.getKey())) {
			this.replies.add(reply.getKey());
		}
	}

	//methods for user conversations
	public List<Key> getUserConversations(){
		return userConversations;
	}

	public void addUserConversation(UserConversation userconvo) {
		if(!this.userConversations.add(userconvo.getKey())){
			this.userConversations.add(userconvo.getKey());
		}
	}
}