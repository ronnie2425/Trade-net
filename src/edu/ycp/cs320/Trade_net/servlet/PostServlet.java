package edu.ycp.cs320.Trade_net.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.Trade_net.controller.PostController;
import edu.ycp.cs320.Trade_net.model.Posts;
import edu.ycp.cs320.Trade_net.model.User;

public class PostServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		//if the user is not logged in send to login page
		if (user == null){
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}
		//if the user is logged in send to listings page
		else{
			req.getRequestDispatcher("/_view/post.jsp").forward(req, resp);

		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//pull the information from the page
		String platform = req.getParameter("platform");
		String game = req.getParameter("game");
		String type = req.getParameter("type");
		String message = req.getParameter("message");
		User user = (User) req.getSession().getAttribute("user");
		int userId = user.getUserId();
		
		Posts post = new Posts(platform, game, 0, type, message, user, 0, userId);
		PostController controller = new PostController(post);
		
		controller.insertPost();		
		
		req.getRequestDispatcher("/_view/listings.jsp").forward(req, resp);		
	}

}
