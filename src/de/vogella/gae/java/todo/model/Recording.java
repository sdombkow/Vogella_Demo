package de.vogella.gae.java.todo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;

import de.vogella.gae.java.todo.dao.PMF;

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
	private List<Key> recording_likes;

	@Persistent
	private List<Key> recording_views;

	@Persistent
	private List<Key> recording_comments;

	@Persistent
	private List<Key> recording_replies;

	@Persistent
	private List<Key> recording_tags;
	
	@Persistent
	private List<Key> recording_listens;

	@Persistent	
	private Date createDate;
	
	@Persistent
	private String recording_file;
	
	@Persistent
	private int recording_length;
	
	@Persistent
	private boolean recording_active;
	
	@Persistent
	private boolean recording_public;
	
	@Persistent
	private int num_likes;
	
	@Persistent
	private int num_replies;

	public Recording(Date date,String recordingFile,int seconds, boolean active, boolean available) {
		this.createDate = date;
		this.recording_file = recordingFile;
		this.recording_length = seconds;
		this.recording_active = active;
		this.recording_public = available;
		this.recording_likes = new ArrayList<Key>();
		this.recording_views = new ArrayList<Key>();
		this.recording_comments= new ArrayList<Key>();
		this.recording_replies = new ArrayList<Key>();
		this.recording_tags = new ArrayList<Key>();
		this.recording_listens = new ArrayList<Key> ();
		this.num_likes = 0;
		this.num_replies = 0;
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
		this.recording_file = file;
	}

	public String getRecordingFile() {
		return this.recording_file;
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
		return recording_likes;
	}

	public void addLike(Like like) {
		if(!this.recording_likes.contains(like.getKey())){
			this.recording_likes.add(like.getKey());
		}
	}
	
	//methods for comments
	public List<Key> getComments() {
		return recording_comments;
	}

	public void addComment(Comment comment) {
		if(!this.recording_comments.contains(comment.getKey())){
			this.recording_comments.add(comment.getKey());
		}	
	}

	//methods for views
	public List<Key> getViews() {
		return recording_views;
	}

	public void addView(View view) {
		if(!this.recording_views.contains(view.getKey())){
			this.recording_views.add(view.getKey());
		}
	}

	//methods for tags
	public List<Key> getTags() {
		return recording_tags;
	}

	public void addTag(Tag tag) {
		if(!this.recording_tags.contains(tag.getKey())){	
		this.recording_tags.add(tag.getKey());
		}
	}

	//methods for replies
	public List<Key> getReplies() {
		return recording_replies;
	}

	public void addReply(Reply reply) {
		if(!this.recording_replies.contains(reply.getKey())){
			this.recording_replies.add(reply.getKey());
		}
	}
	
	//methods for listened
	public List<Key> getListens() {
		return recording_listens;
	}

	public void addListen(Listened listen) {
		if(!this.recording_listens.contains(listen.getKey())){
			this.recording_listens.add(listen.getKey());
		}
	}
	
	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}
	
	public List<Recording>	getPopularCandies() {
		return null;
	}
	
	public List<Recording> getLatestCandies() {
		PersistenceManager mgr = getPersistenceManager();
		List<Recording> results;
		Query q = mgr.newQuery(Recording.class);
		q.setOrdering("createDate desc");
		try {
			results = (List<Recording>) q.execute();
		} finally {
			q.closeAll();
		}
		return results;
	}
	
	public boolean userListen(User user, Recording record) {
		PersistenceManager mgr = getPersistenceManager();
		boolean result = false;
		Key user_listens_key = user.getListened();
		System.out.println(user_listens_key);
		List<Key> user_listens = mgr.getObjectById(Listened.class, user_listens_key).getRecordings();
		int found = user_listens.indexOf(record.getKey());
		if (found != -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean userListenTwo (User user, Recording record) {
		PersistenceManager mgr = getPersistenceManager();
		Query q = mgr.newQuery(Listened.class);
		q.setFilter("user_listened_recordings == recording_param");
		q.declareParameters(Key.class.getName() + " recording_param");
		List<Listened> candy_listeners = (List<Listened>) q.execute(record.getKey());
		for (Listened candy : candy_listeners) {
			System.out.println(candy);
			if (candy.getUser() == user.getKey()) {
				return true;
			}
		}
		return false;
	}
}