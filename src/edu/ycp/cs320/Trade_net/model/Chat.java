
package edu.ycp.cs320.Trade_net.model;

public class Chat
{
	private String message;
	private int msg_id;
	private Posts post;
	private int postid;

	public Chat(String m)
	{
		message = m;
		postid = post.getPostId();
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
	public void setPost(Posts pst)
	{
		post = pst;
	}
	public Posts getPost()
	{
		return post;
	}
	public void setPostId(int pid)
	{
		postid = pid;
	}
	public int getPostId()
	{
		return postid;
	}
} 
