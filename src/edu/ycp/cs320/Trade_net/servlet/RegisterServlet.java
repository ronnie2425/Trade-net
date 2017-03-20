package edu.ycp.cs320.Trade_net.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.Trade_net.model.User;

public class RegisterServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/register.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * check if username already exists in the database and redirect to the login page
		 */
		
		
		/*
		 * if username does not exist update database given information is valid
		 * check for password length, specific characters, sql injections
		 */
		
		
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");		//temp delete when database is set up
		String password2 = req.getParameter("Password2");
		
		User user = new User();
		
		if (password.equals(password2)){
			//create the user, pass it to the model, return to index
			user.setPassword(password);
			user.setUsername(username);
			
			req.setAttribute("user", user);
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);

			
		}
		else{
			req.getRequestDispatcher("/_view/register.jsp").forward(req, resp);

		}
	}

}
