package edu.ycp.cs320.Trade_net.controller;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.Trade_net.model.Register;
import edu.ycp.cs320.Trade_net.database.DatabaseProvider;
import edu.ycp.cs320.Trade_net.database.DerbyDatabase;
import edu.ycp.cs320.Trade_net.database.IDatabase;
import edu.ycp.cs320.Trade_net.model.User;

public class UserController {
	private User user;
	private IDatabase db;
	
	public UserController(){
		//set the database
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	public boolean login(String username, String password){
		//create the database
		IDatabase db = DatabaseProvider.getInstance();
		//get the user from the input username
		List<User> userList = db.findUser(username);
		if (userList.isEmpty()){
			return false;
		}
		User user = userList.get(0);

		//check if the input password matches the user's password
		if (user.getPassword().equals(password)){
			//set the model with the username and password
			this.user.setUsername(user.getUsername());
			this.user.setPassword(user.getPassword());
			//return true to allow the user to login
			return true;
		}
		
		return false;
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
	
	public void setModel(User model){
		//set the model
		user = model;
	}
}
