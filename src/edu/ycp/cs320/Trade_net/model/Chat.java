
package edu.ycp.cs320.Trade_net.model;

public class Chat
{
	private String message;
	private int msg_id;
	private User user;
	private int userid;
	private int postid;

	public Chat(String m)
	{
		message = m;
		userid = 0;
	}
	public Chat()
	{
		
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
	public void setUser(User usr)
	{
		 user = usr;
	}
	public User getUser()
	{
		return user;
	}
	public void setUserId(int uid)
	{
		userid = uid;
	}
	public int getUserId()
	{
		return userid;
	}
	public void setPostId(int pid){
		this.postid = pid;
	}
	public int getPostId(){
		return this.postid;
	}
	public String getUsername(){
		return this.user.getUsername();
	}
} 
