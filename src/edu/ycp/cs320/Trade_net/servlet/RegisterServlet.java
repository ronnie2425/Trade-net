package edu.ycp.cs320.Trade_net.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.Trade_net.controller.RegisterController;
import edu.ycp.cs320.Trade_net.model.Register;
import edu.ycp.cs320.Trade_net.model.User;

public class RegisterServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/register.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");		//temp delete when database is set up
		String password2 = req.getParameter("Password2");
		
		//create register class and set attributes
		User user = new User();
		Register register = new Register();
		register.setPassword(password);
		register.setPassword2(password2);
		register.setUsername(username);
		
		//create controller and set model
		RegisterController controller = new RegisterController(register);
		
		//verify the username being registered does not exist and that passwords match
		if (controller.verify()){
			controller.create();
			
			//send the user to the login page
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}
		/*
		if (password.equals(password2)){
			//create the user, pass it to the model, return to index
			user.setPassword(password);
			user.setUsername(username);
			
			req.getSession().setAttribute("user", user);
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);

			
		}*/
		else{
			req.setAttribute("error", "invalid registration information");
			req.getRequestDispatcher("/_view/register.jsp").forward(req, resp);

		}
	}

}
