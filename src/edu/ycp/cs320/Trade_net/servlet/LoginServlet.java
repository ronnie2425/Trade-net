package edu.ycp.cs320.Trade_net.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.Trade_net.database.DerbyDatabase;
import edu.ycp.cs320.Trade_net.database.IDatabase;
import edu.ycp.cs320.Trade_net.model.User;

public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		
		user.setPassword("password");	//temp until database
		user.setUsername("username");	//remove
		
		//check if input username and password exist
		if (req.getParameter("Username") != null && req.getParameter("Password") != null){
			/*
			 * TODO
			 * Check username and password with database
			 */
			
			//Initial structure for database
			/*String username = req.getParameter("Username");
			String password = req.getParameter("Password");
			
			IDatabase db = new DerbyDatabase();
			List<String> result = db.verifyUserCredentials(username, password);
			
			Iterator itr = result.iterator();
			
			while (itr.hasNext())
				System.out.println(itr.next());
			*/
			
			
			
			if (user.getUsername().equals(req.getParameter("Username"))  && user.getPassword().equals(req.getParameter("Password"))){
				System.out.println("username and password match");
				
				//set the user data into the page
				req.getSession().setAttribute("user", user);	
				req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);

			}
			else{
				System.out.println("username and password do not match");
				//return to login if login fails
				req.setAttribute("error", "Invalid username/password");
				req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
			}
		}
		
		else{
			System.out.println("Invalid username and/or password");
			//return to login if login fails
			req.setAttribute("error", "Invalid username/password");
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}		
	}
}
