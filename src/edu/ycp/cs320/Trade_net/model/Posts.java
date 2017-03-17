package edu.ycp.cs320.Trade_net.model;

public class Posts {
	private String platform, game;
	private double time;
	
	public Posts(String p,String g, double t){
		platform=p;
		game=g;
		time=t;
	}
	public void expire(){
		
	}
	public void notify1(){
		
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
	public String getPlatform(){
		return platform;
	}
	public String getGame(){
		return game;
	}
	public double getTime(){
		return time;
	}
}
