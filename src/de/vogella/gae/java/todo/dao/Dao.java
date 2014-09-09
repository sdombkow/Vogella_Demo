package de.vogella.gae.java.todo.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import de.vogella.gae.java.todo.model.Comment;
import de.vogella.gae.java.todo.model.Conversation;
import de.vogella.gae.java.todo.model.Recording;
import de.vogella.gae.java.todo.model.Reply;
import de.vogella.gae.java.todo.model.Todo;
import de.vogella.gae.java.todo.model.User;
import de.vogella.gae.java.todo.model.Like;
import de.vogella.gae.java.todo.model.UserConversation;
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
	  
	  try {
		  pm.makePersistent(recording1);
          pm.makePersistent(recording2);
          pm.makePersistent(user1);
          pm.makePersistent(user2);
          pm.makePersistent(like1);
          pm.makePersistent(like2);
      } finally {
          pm.close();
      }
	  
	  /*
	  Comment comment1 = new Comment("comment1", user1, recording1);
	  Comment comment2 = new Comment("comment2", user2, recording2);
	  Conversation conversation1 = new Conversation();
	  Conversation conversation2 = new Conversation();
	  UserConversation userconversation1 = new UserConversation(user1, conversation1);
	  UserConversation userconversation2 = new UserConversation(user2, conversation2);
	  Reply reply1 = new Reply(Calendar.getInstance().getTime(), conversation1, user1, recording1);
	  Reply reply2 = new Reply(Calendar.getInstance().getTime(), conversation2, user2, recording2);
	  View view1 = new View(user1, recording1);
	  View view2 = new View(user2, recording2);
	  */
	  
	  PersistenceManager pm2 = PMF.get().getPersistenceManager();
	  
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
	  
	  /*
	  user1.addLike(like1);
	  user1.addLike(like2);
	  user1.addComment(comment1);
	  user1.addComment(comment2);
	  user1.addReply(reply1);
	  user1.addReply(reply2);
	  user1.addView(view1);
	  user1.addView(view2);
	  user1.addUserConversation(userconversation1);
	  user1.addUserConversation(userconversation2);
	  user2.addLike(like1);
	  user2.addLike(like2);
	  user2.addComment(comment1);
	  user2.addComment(comment2);
	  user2.addReply(reply1);
	  user2.addReply(reply2);
	  user2.addView(view1);
	  user2.addView(view2);
	  user2.addUserConversation(userconversation1);
	  user2.addUserConversation(userconversation2);
	  conversation1.addUserConversation(userconversation1);
	  conversation1.addUserConversation(userconversation2);
	  conversation1.addReply(reply1);
	  conversation1.addReply(reply2);
	  conversation2.addUserConversation(userconversation1);
	  conversation2.addUserConversation(userconversation2);
	  conversation2.addReply(reply1);
	  conversation2.addReply(reply2);
	  recording1.addLike(like1);
	  recording1.addComment(comment1);
	  recording1.addReply(reply1);
	  recording1.addView(view1);
	  recording1.addLike(like2);
	  recording1.addComment(comment2);
	  recording1.addReply(reply2);
	  recording1.addView(view2);
	  recording2.addLike(like1);
	  recording2.addComment(comment1);
	  recording2.addReply(reply1);
	  recording2.addView(view1);
	  recording2.addLike(like2);
	  recording2.addComment(comment2);
	  recording2.addReply(reply2);
	  recording2.addView(view2);
	  */
	  
	  /*
	  em.persist(recording1);
	  em.persist(recording2);
	  em.persist(user1);
	  */
	  
	  System.out.println("User1");
	  System.out.println("User Model");
	  for (Key recording : user1.getRecordings()) {
		  	System.out.println("Recording Length: " + pm2.getObjectById(Recording.class,recording).getRecordingLength());
	  }
	  System.out.println("Recording User: " + pm2.getObjectById(User.class,recording1.getUser()).getPhoneNumber());
	  System.out.println("Likes (Skip): " + user1.getLikes());
	  for (Key like : user1.getLikes()) {
	  	System.out.println("Like Comment: " + pm2.getObjectById(Like.class,like).getComment());
	  }
	  /*
	  for (Comment comment : user1.getComments()) {
		  	System.out.println("CommentText: " + comment.getCommentText());
	  }
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
	  
	  System.out.println("Recording Model");
	  for (Key like : recording1.getLikes()) {
		  	System.out.println("Recording Like Comment: " + pm2.getObjectById(Like.class, like).getComment());
	  }
	  /*
	  for (Comment comment : recording1.getComments()) {
		  	System.out.println("Recording CommentText: " + comment.getCommentText());
	  }	
	  for (Reply reply : recording1.getReplies()) {
		  	System.out.println("Recording Reply Phone: " + reply.getUser().getPhoneNumber());
	  }
	  for (View view : recording1.getViews()) {
		  	System.out.println("Recording Reply Phone: " + view.getUser().getPhoneNumber());
	  }
	  */
	  
	  System.out.println("User2");
	  System.out.println("User Model");
	  for (Key recording : user2.getRecordings()) {
		  System.out.println("Recording Length: " + pm2.getObjectById(Recording.class,recording).getRecordingLength());
	  }
	  System.out.println("Recording2 User: " + pm2.getObjectById(User.class,recording2.getUser()).getPhoneNumber());
	  
	  /*
	  for (Like like : user2.getLikes()) {
	  	System.out.println("Like Comment: " + like.getComment());
	  }
	  for (Comment comment : user2.getComments()) {
		  	System.out.println("CommentText: " + comment.getCommentText());
	  }
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
	  
	  System.out.println("Recording Model");
	  for (Key like : recording2.getLikes()) {
		  	System.out.println("Recording Like Comment: " + pm2.getObjectById(Like.class, like).getComment());
	  }
	  /*
	  for (Comment comment : recording2.getComments()) {
		  	System.out.println("Recording CommentText: " + comment.getCommentText());
	  }	
	  for (Reply reply : recording2.getReplies()) {
		  	System.out.println("Recording Reply Phone: " + reply.getUser().getPhoneNumber());
	  }
	  for (View view : recording2.getViews()) {
		  	System.out.println("Recording Reply Phone: " + view.getUser().getPhoneNumber());
	  }
	  */
	  
	  try {
		  pm2.makePersistent(recording1);
          pm2.makePersistent(recording2);
          pm2.makePersistent(user1);
          pm2.makePersistent(user2);
          pm2.makePersistent(like1);
          pm2.makePersistent(like2);
      } finally {
          pm2.close();
      }
	  
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