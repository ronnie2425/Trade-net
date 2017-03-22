package edu.ycp.cs320.Trade_net.model;

public class Posts {
	private String platform, game,buy;
	private double time;
	private User user;
	
	public Posts(String p,String g, double t,String b, User u){
		platform=p;
		game=g;
		time=t;
		buy=b;
		user=u;
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
}
