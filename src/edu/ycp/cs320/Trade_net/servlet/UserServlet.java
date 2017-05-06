package edu.ycp.cs320.Trade_net.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.Trade_net.controller.PostController;
import edu.ycp.cs320.Trade_net.model.Posts;
import edu.ycp.cs320.Trade_net.model.User;

public class UserServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		//if the user is not logged in send to login page
		if (user == null){
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}
		//if the user is logged in send to user info page
		else{
			//grab all of the posts by the user
			PostController controller = new PostController();
			List<Posts> list =controller.getPostsByUserID(user.getUserId());
			req.setAttribute("userlist", list);
			
			req.getRequestDispatcher("/_view/userInfo.jsp").forward(req, resp);

		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String game = req.getParameter("game");
		String type = req.getParameter("type");
		String platform = req.getParameter("platform");
		if(!req.getParameter("postID").equals(null)){
			//remove the selected post
			int postid = Integer.parseInt(req.getParameter("postID"));
			Posts post = new Posts(postid);
			PostController controller = new PostController(post);
			controller.deletePost();
			
			//update the list for userinfo
			User user = (User) req.getSession().getAttribute("user");
			List<Posts> list =controller.getPostsByUserID(user.getUserId());
			req.setAttribute("userlist", list);
		}
		
		else{
			req.setAttribute("gameselected", game);
		}
		req.getRequestDispatcher("/_view/userInfo.jsp").forward(req, resp);

	}
}