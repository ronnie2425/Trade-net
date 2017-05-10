package edu.ycp.cs320.Trade_net.controller;

import java.util.List;

import edu.ycp.cs320.Trade_net.database.DatabaseProvider;
import edu.ycp.cs320.Trade_net.database.DerbyDatabase;
import edu.ycp.cs320.Trade_net.database.IDatabase;
import edu.ycp.cs320.Trade_net.model.Chat;
import edu.ycp.cs320.Trade_net.model.User;

public class ChatController {
	
	private Chat chat;
	private IDatabase db;
	
	public ChatController(Chat c)
	{
		chat = c;
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();


		
	}
	public void insertChat(){
		db.insertChat(chat.getMsg(), chat.getUserId(), chat.getPostId());
	}
	
	public List<Chat> findChat(){
		return db.findChatbyPost(chat.getPostId());
		//return null;
	}
	
	public String findUserName(){
		List<User> userlist = db.findUser(chat.getUserId());
		return userlist.get(0).getUsername();
	}

	
	

}
