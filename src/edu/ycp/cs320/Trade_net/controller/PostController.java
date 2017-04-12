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
		
	}
	public void notify1(){
		
	}
	public List<Posts> getPosts(){
		IDatabase db = DatabaseProvider.getInstance();
		List<Posts> postList = db.findPosts(post.getPlatform(),post.getGame(),post.getBuy());
		return postList;
	}
}
