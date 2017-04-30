package edu.ycp.cs320.Trade_net.controller;

import java.util.List;

import edu.ycp.cs320.Trade_net.database.DatabaseProvider;
import edu.ycp.cs320.Trade_net.database.DerbyDatabase;
import edu.ycp.cs320.Trade_net.database.IDatabase;
import edu.ycp.cs320.Trade_net.model.User;
import edu.ycp.cs320.Trade_net.model.Posts;

public class PostController {
	private Posts post;
	private IDatabase db;
	
	
	public PostController(Posts post){
		this.post=post;
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	public void expire(){
		if (post.getTime()==0){
			db = DatabaseProvider.getInstance();
			db.deletePost(post);
		}
	}
	public void notify1(){
		
		db = DatabaseProvider.getInstance();
		List<User> userl=db.findUser(post.getUserId());
		User user=userl.get(0);
		String message= user.getUsername()+ " would like to chat.";
		
		db.insertNotification(post.getUserId(), message);
	}
	public List<Posts> getPosts(){
		db = DatabaseProvider.getInstance();
		List<Posts> postList = db.findPosts(post.getPlatform(),post.getGame(),post.getBuy());
		return postList;
	}
	
	public void insertPost(){
		db.insertPost(post.getUserId(), post.getPlatform(), post.getGame(), post.getBuy(), (int)post.getTime(), post.getMessage());
	}
}
