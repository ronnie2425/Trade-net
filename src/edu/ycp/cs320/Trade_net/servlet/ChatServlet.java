package edu.ycp.cs320.Trade_net.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.Trade_net.controller.ChatController;
import edu.ycp.cs320.Trade_net.model.Chat;
import edu.ycp.cs320.Trade_net.model.User;

public class ChatServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//send to login if user is not logged in
		User user = (User) req.getSession().getAttribute("user");
		if (user == null){
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}
		//pull the postid from the post clicked in listings
		int postid = Integer.parseInt(req.getParameter("postid"));
		System.out.println("post id found is" +postid);
		Chat chat = new Chat();
		chat.setPostId(postid);
		System.out.println("user's id is: " +user.getUserId());
		
		ChatController controller = new ChatController(chat);
		List<Chat> chatlist = controller.findChat();
		
		if (!(chatlist == null) && !chatlist.isEmpty()){
			req.setAttribute("chatlist", chatlist);

		}
		req.getSession().setAttribute("postid", chat.getPostId());
		
		
		
		//send to chat if user is logged in
		req.getRequestDispatcher("/_view/chat.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		
		String input = req.getParameter("userinput");
		Chat chat = new Chat();
		chat.setMsg(input);
		chat.setUser(user);
		chat.setUserId(user.getUserId());
		chat.setPostId((Integer)req.getSession().getAttribute("postid"));
		
		//insert into the chat
		ChatController controller = new ChatController(chat);
		if (!input.equals("")){
			controller.insertChat();
		}
		
		//retrieve the updated chat
		List<Chat> chatlist = controller.findChat();
		if (!(chatlist == null) && !chatlist.isEmpty()){
			req.setAttribute("chatlist", chatlist);

		}
		
		req.getRequestDispatcher("/_view/chat.jsp").forward(req, resp);
		
	}
}