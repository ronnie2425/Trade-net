package edu.ycp.cs320.Trade_net.model;

public class Posts {
	private String platform, game,buy,message;
	private double time;
	private User user;
	private int post_id,user_id;
	
	public Posts(String p,String g, double t,String b,String m, User u,int pid,int uid){
		platform=p;
		game=g;
		time=t;
		buy=b;
		user=u;
		post_id=pid;
		user_id=uid;
		message=m;
	}
	public Posts(){
		
	}
	public void setPlatform(String u){
		platform=u;
	}
	public void setGame(String p){
		game=p;
	}
	public void setEmail(double t){
		time=t;
	}
	public void setBuy(String b){
		buy=b;
	}
	public void setUser(User u){
		user=u;
	}
	public void setUserId(int u){
		user_id=u;
	}
	public void setPostId(int u){
		post_id=u;
	}
	public void setMessage(String u){
		message=u;
	}
	public void setTime(double t){
		time=t;
	}
	public String getPlatform(){
		return platform;
	}
	public String getGame(){
		return game;
	}
	public String getBuy(){
		return buy;
	}
	public double getTime(){
		return time;
	}
	public User getUser(){
		return user;
	}
	public int getUserId(){
		return user_id;
	}
	public int getPostId(){
		return post_id;
	}
	public String getMessage(){
		return message;
	}
}
