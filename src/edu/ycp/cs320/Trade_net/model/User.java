package edu.ycp.cs320.Trade_net.model;

public class User {
	private String username, password, email;
	private int user_id,usern;
	
	public User(){
		
	}
	
	public User(String u,String p,String e,int id){
		username=u;
		password=p;
		email=e;
		user_id=id;
	}
	public void setUsername(String u){
		username=u;
	}
	public void setPassword(String p){
		password=p;
	}
	public void setEmail(String e){
		email=e;
	}
	public void setUserId(int e){
		user_id=e;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getEmail(){
		return email;
	}
	public int getUserId(){
		return user_id;
	}
}
