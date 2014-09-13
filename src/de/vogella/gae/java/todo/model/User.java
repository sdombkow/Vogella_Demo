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
    private List<Key> user_recordings;

	@Persistent
    private List<Key> user_groups;
	
	@Persistent
	private List<Key> user_likes;
	
	@Persistent
	private List<Key> user_comments;

	@Persistent
	private List<Key> user_views;

	@Persistent
	private List<Key> user_replies;

	@Persistent
	private List<Key> user_conversations;

	@Persistent
	private String phone_number;
	
	@Persistent
	private String primary_email_address;
	
	@Persistent
	private String password;
	
	@Persistent
	private String token;
	
	@Persistent
	private Date create_date;

	public User(String phone_number, String primary_email_address, String password, Date date, String token) {
		this.phone_number= phone_number;
		this.primary_email_address= primary_email_address;
		this.password = password;
		this.create_date = date;
		this.token = token;
		this.user_recordings = new ArrayList<Key>();
		this.user_groups = new ArrayList<Key>();
		this.user_likes = new ArrayList<Key>();
		this.user_comments = new ArrayList<Key>();
		this.user_views = new ArrayList<Key>();
		this.user_replies = new ArrayList<Key>();
		this.user_conversations = new ArrayList<Key>();
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
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
		return user_recordings;
	}

	public void addRecording(Recording recording) {
		if(!this.user_recordings.contains(recording.getKey())){
			this.user_recordings.add(recording.getKey());
		}		
	}
	
	//methods for groups
	public List<Key> getGroups() {
		return user_groups;
	}

	public void addGroup(Group group) {
		if(!this.user_groups.contains(group.getKey())){
			this.user_groups.add(group.getKey());
		}		
	}

	//methods for likes
	public List<Key> getLikes(){
		return user_likes;
	}

	public void addLike(Like like) {
		if(!this.user_likes.contains(like.getKey())){
			this.user_likes.add(like.getKey());
		}
	}

	//methods for comments
	public List<Key> getComments(){
		return user_comments;
	}

	public void addComment(Comment comment) {
		if(!this.user_comments.contains(comment.getKey())){
			this.user_comments.add(comment.getKey());
		}
	}

	//methods for view
	public List<Key> getViews(){
		return user_views;
	}

	public void addView(View view) {
		if(!this.user_views.contains(view.getKey())){
			this.user_views.add(view.getKey());
		}
	}

	//methods for replies
	public List<Key> getReplies(){
		return user_replies;
	}

	public void addReply(Reply reply) {
		if(!this.user_replies.contains(reply.getKey())) {
			this.user_replies.add(reply.getKey());
		}
	}

	//methods for user conversations
	public List<Key> getConversations(){
		return user_conversations;
	}

	public void addConversation(Conversation userconvo) {
		if(!this.user_conversations.add(userconvo.getKey())){
			this.user_conversations.add(userconvo.getKey());
		}
	}
}