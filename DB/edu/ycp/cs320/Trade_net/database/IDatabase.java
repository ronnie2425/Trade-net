package edu.ycp.cs320.Trade_net.database;

import java.util.List;

import com.fasterxml.jackson.databind.AnnotationIntrospector.Pair;

import edu.ycp.cs320.Trade_net.model.User;
import edu.ycp.cs320.Trade_net.model.Posts;
import edu.ycp.cs320.Trade_net.model.Chat;
import edu.ycp.cs320.Trade_net.model.Notification;


public interface IDatabase {
	public List<User> findUser(String username);
	public List<User> findUser(int user_id);
	public List<Posts> findPosts(String platform,String game, String buy);
	public List<Notification> findNot(int post_id);
	public List<Notification> insertNotification(int user_id,String message);
	public List<User> insertUser(String username,String password, String email);
	public List<Posts> insertPost( int userid, String platform, String game, String trade , int time,  String message);
	public List<Posts> deletePost(Posts post);
	public List<Chat> insertChat(final String message,final int userid, final int postid);
	public List<Chat> findChatbyPost(final int post_id);
	public List<Posts> findPostsByUserID(int user_id);
}
