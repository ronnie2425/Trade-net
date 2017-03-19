package edu.ycp.cs320.Trade_net.model;

public class Register {
	private String username, password, password2, email;
	
	public Register(String u,String p, String p2,String e){
		username=u;
		password=p;
		password2=p2;
		email=e;
	}
	public Register(){
		
	}
	public void verify(){
		
	}
	public void create(){
		
	}
	public void setUsername(String u){
		username=u;
	}
	public void setPassword(String p){
		password=p;
	}
	public void setPassword2(String p2){
		password2=p2;
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
	public String getPassword2(){
		return password2;
	}
}
