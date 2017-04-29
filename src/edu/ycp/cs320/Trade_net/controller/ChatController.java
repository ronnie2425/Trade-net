package edu.ycp.cs320.Trade_net.controller;

import edu.ycp.cs320.Trade_net.database.DatabaseProvider;
import edu.ycp.cs320.Trade_net.database.DerbyDatabase;
import edu.ycp.cs320.Trade_net.database.IDatabase;
import edu.ycp.cs320.Trade_net.model.Chat;

public class ChatController {
	
	private Chat chat;
	private IDatabase db;
	
	public ChatController(Chat c)
	{
		chat = c;
	}
	
}
