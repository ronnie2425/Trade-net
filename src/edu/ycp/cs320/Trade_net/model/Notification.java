package edu.ycp.cs320.Trade_net.model;

public class Notification {
	private String notification;
	private User user;
	private int user_id,not_id;
	
	public Notification(String n,User u){
		notification=n;
		user=u;
	}
	public Notification(){
		
	}
	public void setNotification(String n){
		notification=n;
	}
	public void setUser(User u){
		user=u;
	}
	public void setUserId(int u){
		user_id=u;
	}
	public void setNotificationId(int u){
		not_id=u;
	}
	public String getNotification(){
		return notification;
	}
	public User getUser(){
		return user;
	}
	public int getUserId(){
		return user_id;
	}
	public int getNotificationId(){
		return not_id;
	}
}
