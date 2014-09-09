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
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class User {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent (mappedBy = "user")
    private List<Key> recordings;
	
	@Persistent(mappedBy = "user")
	private List<Key> likes;
	
	/*
	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "user")
	private List<Comment> comments;

	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "user")
	private List<Recording> recordings;

	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "user")
	private List<View> views;

	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "user")
	private List<Reply> replies;

	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "user")
	private List<UserConversation> userConversations;
	*/

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
		this.recordings = new ArrayList<Key>();
		this.likes = new ArrayList<Key>();
		/*
		this.comments = new ArrayList<Comment>();
		this.views = new ArrayList<View>();
		this.replies = new ArrayList<Reply>();
		this.userConversations = new ArrayList<UserConversation>();
		*/
	}

	public Key getKey(){
		return key;
	}

	public String getPhoneNumber(){
		return phone_number;
	}

	public void setPhoneNumer(String number){
		this.phone_number = number;
	}


	public String getPrimaryEmail_address(){
		return primary_email_address;
	}

	public void setPrimaryEmailAddress(String email){
		this.primary_email_address = email;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public Date getCreateDate(){
		return create_date;
	}

	public void setCreateDate(Date date){
		this.create_date = date;
	}
	
	//methods for recordings
	public List<Key> getRecordings(){
		return recordings;
	}

	public void addRecording(Recording recording) {
		System.out.println("In Add Recording");
		System.out.println("Recording Key Before: " + recording.getKey());
		if(!this.recordings.contains(recording.getKey())){
			System.out.println("In Add Recording Contains Get Key");
			this.recordings.add(recording.getKey());
			for (Key test: recordings) {
				System.out.println("Recording Key After: " + test);
			}
		}		
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
			if(comment.getUser() != this){
				comment.setUser(this);
			}
		}
	}

	//methods for recordings
	public List<Recording> getRecordings(){
		return recordings;
	}

	public void addRecording(Recording recording) {
		if(!this.recordings.contains(recording)){
			this.recordings.add(recording);
			if(recording.getUser() != this){
				recording.setUser(this);
			}
		}
	}

	//methods for view
	public List<View> getViews(){
		return views;
	}

	public void addView(View view) {
		if(!this.views.contains(view.getID())){
			this.views.add(view);
			if(view.getUser() != this){
				view.setUser(this);
			}
		}
	}

	//methods for replies
	public List<Reply> getReplies(){
		return replies;
	}

	public void addReply(Reply reply) {
		if(!this.replies.contains(reply)) {
			this.replies.add(reply);
			if(reply.getUser() != this){
				reply.setUser(this);
			}
		}
	}

	//methods for user conversations
	public List<UserConversation> getUserConversations(){
		return userConversations;
	}

	public void addUserConversation(UserConversation userconvo) {
		if(!this.userConversations.add(userconvo)){
			this.userConversations.add(userconvo);
			if(userconvo.getUser() != this){
				userconvo.setUser(this);
			}
		}
	}
	*/
}