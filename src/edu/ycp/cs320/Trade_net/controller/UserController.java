package edu.ycp.cs320.Trade_net.controller;

import java.util.List;

import edu.ycp.cs320.Trade_net.model.Register;
import edu.ycp.cs320.Trade_net.database.DatabaseProvider;
import edu.ycp.cs320.Trade_net.database.IDatabase;
import edu.ycp.cs320.Trade_net.model.User;

public class UserController {
	
	public void login(){
		
	}
	public void logout(){
		
	}
	public void post(User user,String platform,String game, String buy,String message){
		IDatabase db = DatabaseProvider.getInstance();
		db.insertPost(user.getUserId(), platform, game, buy, 30, message);
	}
	public void chat(){
		
	}
	public void trade(){
		
	}
}
