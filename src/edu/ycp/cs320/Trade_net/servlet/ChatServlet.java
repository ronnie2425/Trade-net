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
		/*
		//get the input
		String input = (req.getParameter("userinput"));
		//get the previous messages
		ArrayList<String> messages = new ArrayList<String>();
		if (req.getSession().getAttribute("messages") != null){
			messages = (ArrayList<String>) req.getSession().getAttribute("messages");

		}		
		//add the input to the set of messages
		messages.add(input);
		req.getSession().setAttribute("messages", messages);
		
		/*
		 * TODO
		 * Pull the user's name and send it along with the message as a list
		 * Some type of scrolling implementation to prevent going off the chat box
		 * send the list of messages to the database
		 */
		User user = (User) req.getSession().getAttribute("user");
		String input = req.getParameter("userinput");
		Chat chat = new Chat();
		chat.setMsg(input);
		chat.setUser(user);
		chat.setUserId(user.getUserId());
		chat.setPostId((Integer)req.getSession().getAttribute("postid"));
		
		
		ChatController controller = new ChatController(chat);
		if (!input.equals("")){
			controller.insertChat();
		}
		
		req.getRequestDispatcher("/_view/chat.jsp").forward(req, resp);
		
	}
}