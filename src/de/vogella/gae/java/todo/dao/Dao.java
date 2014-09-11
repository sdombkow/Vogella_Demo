package de.vogella.gae.java.todo.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import de.vogella.gae.java.todo.model.Comment;
import de.vogella.gae.java.todo.model.Conversation;
import de.vogella.gae.java.todo.model.Group;
import de.vogella.gae.java.todo.model.Recording;
import de.vogella.gae.java.todo.model.Reply;
import de.vogella.gae.java.todo.model.Tag;
import de.vogella.gae.java.todo.model.Todo;
import de.vogella.gae.java.todo.model.User;
import de.vogella.gae.java.todo.model.Like;
import de.vogella.gae.java.todo.model.UserConversation;
import de.vogella.gae.java.todo.model.UserGroup;
import de.vogella.gae.java.todo.model.View;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.google.appengine.api.datastore.Key;

public enum Dao {
  INSTANCE;

  /*
  public List<Todo> listTodos() {
    EntityManager em = EMFService.get().createEntityManager();
    // read the existing entries
    Query q = em.createQuery("select m from Todo m");
    List<Todo> todos = q.getResultList();
    return todos;
  }

  public void add(String userId, String summary, String description, String url) {
    synchronized (this) {
      EntityManager em = EMFService.get().createEntityManager();
      Todo todo = new Todo(userId, summary, description, url);
      em.persist(todo);
      em.close();
    }
  }
  */

  public boolean getTodos(String userId) {
	  //EntityManager em = EMFService.get().createEntityManager();
	  //Query q = em.createQuery("select t from Todo t where t.author = :userId");
	  //q.setParameter("userId", userId);
	  //List<Todo> todos = q.getResultList();
	  PersistenceManager pm = PMF.get().getPersistenceManager();
	  
	  User user1 = new User("812324213","test1@example.com","password",Calendar.getInstance().getTime());
	  User user2 = new User("234912371","test2@example.com","password",Calendar.getInstance().getTime());
	  Recording recording1 = new Recording(Calendar.getInstance().getTime(),"test",45,true,true);
	  Recording recording2 = new Recording(Calendar.getInstance().getTime(),"test #2",60,true,true);
	  Like like1 = new Like("test1");
	  Like like2 = new Like("test2");
	  Comment comment1 = new Comment("comment1");
	  Comment comment2 = new Comment("comment2");
	  Conversation conversation1 = new Conversation();
	  Conversation conversation2 = new Conversation();
	  UserConversation userconversation1 = new UserConversation();
	  UserConversation userconversation2 = new UserConversation();
	  
	  pm.makePersistent(user1);
      pm.makePersistent(user2);
      pm.makePersistent(recording1);
      pm.makePersistent(recording2);
      pm.makePersistent(like1);
      pm.makePersistent(like2);
      pm.makePersistent(comment1);
      pm.makePersistent(comment2);
      pm.makePersistent(userconversation1);
      pm.makePersistent(userconversation2);
	  
	  user1.addRecording(recording1);
	  user2.addRecording(recording2);
	  recording1.setUser(user1);
	  recording2.setUser(user2);
	  like1.setUser(user1);
	  like2.setUser(user1);
	  like1.setRecording(recording1);
	  like2.setRecording(recording2);
	  user1.addLike(like1);
	  user1.addLike(like2);
	  recording1.addLike(like1);
	  recording2.addLike(like2);
	  user1.addComment(comment1);
	  user1.addComment(comment2);
	  recording1.addComment(comment1);
	  recording2.addComment(comment2);
	  comment1.setUser(user1);
	  comment2.setUser(user1);
	  comment1.setRecording(recording1);
	  comment2.setRecording(recording2);
	  user1.addUserConversation(userconversation1);
	  user1.addUserConversation(userconversation2);
	  user2.addUserConversation(userconversation1);
	  user2.addUserConversation(userconversation2);
	  userconversation1.setUser(user1);
	  userconversation1.setUser(user2);
	  userconversation2.setUser(user1);
	  userconversation2.setUser(user2);
	  conversation1.addUserConversation(userconversation1);
	  conversation1.addUserConversation(userconversation2);
	  conversation2.addUserConversation(userconversation1);
	  conversation2.addUserConversation(userconversation2);
	  
	  try {
          pm.makePersistent(user1);
          pm.makePersistent(user2);
          pm.makePersistent(recording1);
          pm.makePersistent(recording2);
          pm.makePersistent(like1);
          pm.makePersistent(like2);
          pm.makePersistent(comment1);
          pm.makePersistent(comment2);
          pm.makePersistent(userconversation1);
          pm.makePersistent(userconversation2);
          
          for (Key recording : user1.getRecordings()) {
  		  	System.out.println("User 1 Recording Length: " + pm.getObjectById(Recording.class, recording).getRecordingLength());
  		  	System.out.println("Recording User: " + pm.getObjectById(User.class, pm.getObjectById(Recording.class, recording).getUser()).getPhoneNumber());
          }
          System.out.println("Likes (Skip): " + user1.getLikes());
          for (Key like : user1.getLikes()) {
        	  System.out.println("User1 Like Comment: " + pm.getObjectById(Like.class, like).getComment());
        	  System.out.println("Like User: " + pm.getObjectById(Like.class, like).getUser());
          }
          for (Key comment : user1.getComments()) {
        	  System.out.println("User1 Comment Text: " + pm.getObjectById(Comment.class, comment).getCommentText());
          }
          System.out.println("Recording Model");
    	  for (Key like : recording1.getLikes()) {
    		  	System.out.println("Recording1 Like Comment: " + pm.getObjectById(Like.class, like).getComment());
    	  }
    	  for (Key comment : recording1.getComments()) {
    		  	System.out.println("Recording1 CommentText: " + pm.getObjectById(Comment.class, comment).getCommentText());
    	  }
    	  System.out.println("User2");
    	  System.out.println("User Model");
    	  for (Key recording : user2.getRecordings()) {
    		  System.out.println("User2 Recording Length: " + pm.getObjectById(Recording.class,recording).getRecordingLength());
    		  System.out.println("Recording User: " + pm.getObjectById(User.class, pm.getObjectById(Recording.class, recording).getUser()).getPhoneNumber());
    	  }
    	  for (Key comment : user2.getComments()) {
  		  	System.out.println("User2 Comment Text: " + pm.getObjectById(Comment.class, comment).getCommentText());
    	  }
    	  System.out.println("Recording Model");
    	  for (Key like : recording2.getLikes()) {
    		  	System.out.println("Recording2 Like Comment: " + pm.getObjectById(Like.class, like).getComment());
    	  }
    	  for (Key comment : recording2.getComments()) {
    		  	System.out.println("Recording2 Comment Text: " + pm.getObjectById(Comment.class, comment).getCommentText());
    	  }
      } finally {
          pm.close();
      }
	  
	  PersistenceManager pm3 = PMF.get().getPersistenceManager();
	  
	  Reply reply1 = new Reply(Calendar.getInstance().getTime());
	  Reply reply2 = new Reply(Calendar.getInstance().getTime());
	  View view1 = new View();
	  View view2 = new View();
	  
	  pm3.makePersistent(reply1);
	  pm3.makePersistent(reply2);
	  pm3.makePersistent(view1);
	  pm3.makePersistent(view2);
	  pm3.makePersistent(user1);
	  pm3.makePersistent(user2);
	  pm3.makePersistent(conversation1);
	  pm3.makePersistent(conversation2);
	  pm3.makePersistent(recording1);
	  pm3.makePersistent(recording2);
	  
	  user1.addReply(reply1);
	  user1.addReply(reply2);
	  user1.addView(view1);
	  user1.addView(view2);
	  reply1.setUser(user1);
	  reply2.setUser(user1);
	  view1.setUser(user1);
	  view2.setUser(user1);
	  conversation1.addReply(reply1);
	  conversation2.addReply(reply2);
	  reply1.setConversation(conversation1);
	  reply2.setConversation(conversation2);
	  view1.setRecording(recording1);
	  view2.setRecording(recording2);
	  recording1.addView(view1);
	  recording2.addView(view2);
	  reply1.setRecording(recording1);
	  reply2.setRecording(recording2);
	  
	  try {
		  pm3.makePersistent(reply1);
		  pm3.makePersistent(reply2);
		  pm3.makePersistent(view1);
		  pm3.makePersistent(view2);
		  pm3.makePersistent(user1);
		  pm3.makePersistent(user2);
		  pm3.makePersistent(conversation1);
		  pm3.makePersistent(conversation2);
		  pm3.makePersistent(recording1);
		  pm3.makePersistent(recording2);
      } finally {
          pm3.close();
      }
	  
	  PersistenceManager pm4 = PMF.get().getPersistenceManager();
	  
	  Group group1 = new Group("test group1","test group1");
	  Group group2 = new Group("test group2","test group2");
	  UserGroup usergroup1 = new UserGroup();
	  UserGroup usergroup2 = new UserGroup();
	  Tag tag1 = new Tag("test tag1");
	  Tag tag2 = new Tag("test tag2");
	  
	  pm4.makePersistent(group1);
	  pm4.makePersistent(group2);
	  pm4.makePersistent(usergroup1);
	  pm4.makePersistent(usergroup2);
	  pm4.makePersistent(tag1);
	  pm4.makePersistent(tag2);
	  
	  group1.addUserGroup(usergroup1);
	  group1.addUserGroup(usergroup2);
	  usergroup1.setGroup(group1);
	  usergroup2.setGroup(group2);
	  group1.addRecording(recording1);
	  group1.addRecording(recording2);
	  recording1.setGroup(group1);
	  recording2.setGroup(group2);
	  usergroup1.setUser(user1);
	  usergroup2.setUser(user2);
	  user1.addGroup(group1);
	  user2.addGroup(group2);
	  tag1.setRecording(recording2);
	  tag2.setRecording(recording2);
	  recording2.addTag(tag1);
	  recording2.addTag(tag2);
	  
	  try {
		  pm4.makePersistent(group1);
		  pm4.makePersistent(group2);
		  pm4.makePersistent(usergroup1);
		  pm4.makePersistent(usergroup2);
		  pm4.makePersistent(tag1);
		  pm4.makePersistent(tag2);
		  pm4.makePersistent(recording1);
		  pm4.makePersistent(recording2);
		  pm4.makePersistent(user1);
		  pm4.makePersistent(user2);

      } finally {
          pm4.close();
      }
	  

	  
	  /*
	  for (Reply reply : user1.getReplies()) {
		  	System.out.println("User Reply Phone: " + reply.getUser().getPhoneNumber());
	  }
	  for (Recording recording : user1.getRecordings()) {
		  	System.out.println("Recording Length: " + recording.getRecordingLength());
	  }
	  for (View view : user1.getViews()) {
		  	System.out.println("User Reply Phone: " + view.getUser().getPhoneNumber());
	  }
	  for (UserConversation userconversation : user1.getUserConversations()) {
		  	System.out.println("User Conversation Phone: " + userconversation.getUser().getPhoneNumber());
	  }
	  
	  System.out.println("Conversation Model");
	  for (Reply reply : conversation1.getReplies()) {
		  	System.out.println("User Reply Phone: " + reply.getUser().getPhoneNumber());
	  }
	  for (UserConversation userconversation : conversation1.getUserConversations()) {
		  	System.out.println("User Conversation Phone: " + userconversation.getUser().getPhoneNumber());
	  }
	  */
	  
	  
	  /*
	  for (Reply reply : recording1.getReplies()) {
		  	System.out.println("Recording Reply Phone: " + reply.getUser().getPhoneNumber());
	  }
	  for (View view : recording1.getViews()) {
		  	System.out.println("Recording Reply Phone: " + view.getUser().getPhoneNumber());
	  }
	  */
	  
	  
	  
	  /*
	  for (Key like : user2.getLikes()) {
	  	System.out.println("Like Comment: " + pm2.getObjectById(Like.class, like).getComment());
	  }
	  */

	  
	  /*
	  for (Reply reply : user2.getReplies()) {
		  	System.out.println("User Reply Phone: " + reply.getUser().getPhoneNumber());
	  }
	  for (View view : user2.getViews()) {
		  	System.out.println("User Reply Phone: " + view.getUser().getPhoneNumber());
	  }
	  for (UserConversation userconversation : user2.getUserConversations()) {
		  	System.out.println("User Conversation Phone: " + userconversation.getUser().getPhoneNumber());
	  }
	  
	  System.out.println("Conversation Model");
	  for (Reply reply : conversation2.getReplies()) {
		  	System.out.println("User Reply Phone: " + reply.getUser().getPhoneNumber());
	  }
	  for (UserConversation userconversation : conversation2.getUserConversations()) {
		  	System.out.println("User Conversation Phone: " + userconversation.getUser().getPhoneNumber());
	  } 
	  */
	  
	  /*
	  for (Reply reply : recording2.getReplies()) {
		  	System.out.println("Recording Reply Phone: " + reply.getUser().getPhoneNumber());
	  }
	  for (View view : recording2.getViews()) {
		  	System.out.println("Recording Reply Phone: " + view.getUser().getPhoneNumber());
	  }
	  */
	  
	  return true;
  }

  /*
  public void remove(long id) {
    EntityManager em = EMFService.get().createEntityManager();
    try {
      Todo todo = em.find(Todo.class, id);
      em.remove(todo);
    } finally {
      em.close();
    }
  }
  */
}