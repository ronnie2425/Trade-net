package edu.ycp.cs320.Trade_net.database;

import java.util.List;

import com.fasterxml.jackson.databind.AnnotationIntrospector.Pair;

import edu.ycp.cs320.Trade_net.model.User;
import edu.ycp.cs320.Trade_net.model.Posts;
import edu.ycp.cs320.Trade_net.model.Notification;


public interface IDatabase {
	public List<User> findUser(String username);
	public List<Posts> findPosts(String platform,String game, String buy);
	public List<Notification> findNot(int post_id);
}
