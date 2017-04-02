package edu.ycp.cs320.Trade_net.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//send to chat if user is logged in
		req.getRequestDispatcher("/_view/chat.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String input = (req.getParameter("userinput"));
		
		
		req.getRequestDispatcher("/_view/chat.jsp").forward(req, resp);
		
	}
}