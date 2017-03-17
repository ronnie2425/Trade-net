package edu.ycp.cs320.Trade_net.model;

public class Notification {
	private String notification;
	private User user;
	
	public Notification(String n,User u){
		notification=n;
		user=u;
	}
	public void notify1(){
		
	}
	public void setNotification(String n){
		notification=n;
	}
	public void setUser(User u){
		user=u;
	}
	public String getNotification(){
		return notification;
	}
	public User getUser(){
		return user;
	}
}
