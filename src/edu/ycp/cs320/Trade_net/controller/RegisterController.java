package edu.ycp.cs320.Trade_net.controller;

import java.util.List;

import edu.ycp.cs320.Trade_net.model.Register;
import edu.ycp.cs320.Trade_net.database.DatabaseProvider;

import edu.ycp.cs320.Trade_net.database.DerbyDatabase;

import edu.ycp.cs320.Trade_net.database.IDatabase;
import edu.ycp.cs320.Trade_net.model.User;


public class RegisterController {
	private Register register;
	;
	
	public RegisterController(Register r){
		register=r;
		DatabaseProvider.setInstance(new DerbyDatabase());
		//db = DatabaseProvider.getInstance();
	}
	public boolean verify(){
		if (!register.getPassword().equals(register.getPassword2())){
			return false;
		}
		if (register.getPassword().length() < 4 || register.getUsername().length() < 4){
			return false;
		}

		IDatabase db = DatabaseProvider.getInstance();
		List<User> userList = db.findUser(register.getUsername());
		if (!userList.isEmpty())

			return false;
		else
			return true;
	}
	public void create(){
			IDatabase db = DatabaseProvider.getInstance();
			db.insertUser(register.getUsername(),register.getPassword(),register.getEmail());
		
		
	}
}
