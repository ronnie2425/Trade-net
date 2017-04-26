package edu.ycp.cs320.Trade_net.model;

public class Chat
{
	private String message;
	private int msg_id;
	private Posts post;
	private User user;
	
	public Chat(String m, int mid, Posts p, User u)
	{
		message = m;
		msg_id = mid;
		post = p;
		user = u;
	}
	public void setMsg(String msg)
	{
		message = msg;
	}
	public String getMsg()
	{
		return message;
	}
	public void setMsgId(int Msgid)
	{
		msg_id = Msgid;
	}
	public int getMsgId()
	{
		return msg_id;
	}
	public void setPost(Posts pst)
	{
		post = pst;
	}
	public Posts getPost()
	{
		return post;
	}
	public void setUser(User usr)
	{
		user = usr;
	}
	public User getUser()
	{
		return user;
	}
}