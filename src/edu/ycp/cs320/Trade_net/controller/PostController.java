package edu.ycp.cs320.Trade_net.controller;

import java.util.List;

import edu.ycp.cs320.Trade_net.database.DatabaseProvider;
import edu.ycp.cs320.Trade_net.database.IDatabase;
import edu.ycp.cs320.Trade_net.model.User;
import edu.ycp.cs320.Trade_net.model.Posts;

public class PostController {
	private Posts post;
	
	public PostController(Posts post){
		this.post=post;
	}
	public void expire(){
		if (post.getTime()==0){
			IDatabase db = DatabaseProvider.getInstance();
			db.deletePost(post);
		}
	}
	public void notify1(){
		
		IDatabase db = DatabaseProvider.getInstance();
		List<User> userl=db.findUser(post.getUserId());
		User user=userl.get(0);
		String message= user.getUsername()+ " would like to chat.";
		
		db.insertNotification(post.getUserId(), message);
	}
	public List<Posts> getPosts(String platform,String game,String buy){
		IDatabase db = DatabaseProvider.getInstance();
		List<Posts> postList = db.findPosts(platform,game,buy);
		return postList;
	}
	public void deletePost(){
		IDatabase db = DatabaseProvider.getInstance();
		db.deletePost(post);
	}
	
}
