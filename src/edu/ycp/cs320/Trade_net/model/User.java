package edu.ycp.cs320.Trade_net.model;

public class User {
	private String username, password, email;
	
	public User(){
		
	}
	
	public User(String u,String p,String e){
		username=u;
		password=p;
		email=e;
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
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getEmail(){
		return email;
	}
}
