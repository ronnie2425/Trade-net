package edu.ycp.cs320.Trade_net.controller;

import edu.ycp.cs320.Trade_net.model.Register;;

public class RegisterController {
	private Register register;
	
	public RegisterController(Register r){
		register=r;
	}
	public boolean verify(){
		if (register.getPassword()!=register.getPassword2()){
			return false;
		}
		return true;
	}
	public void create(){
		
	}
}
