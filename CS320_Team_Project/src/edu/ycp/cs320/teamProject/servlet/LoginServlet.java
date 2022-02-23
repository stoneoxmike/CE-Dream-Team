package edu.ycp.cs320.teamProject.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.teamProject.controller.LoginController;
import edu.ycp.cs320.teamProject.model.Login;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Login Servlet: doGet");
		
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Login model = new Login();
		
		System.out.println("Login Servlet: doPost");
		

		// holds the error message text, if there is any
		String errorMessage = null;

		
		// decode POSTed form parameters and dispatch to controller
		try {
			model.setUsername(getStringFromParameter(req.getParameter("username")));
			model.setPassword(getStringFromParameter(req.getParameter("password")));

			// check for errors in the form data before using is in a calculation
			if (model.getUsername() == null) {
				errorMessage = "Please enter a username";
			}
			else if (model.getPassword() == null)
			{
				errorMessage = "Please enter a password";
			}
			// otherwise, data is good,
			// must create the controller each time, since it doesn't persist between POSTs
			// the view does not alter data, only controller methods should be used for that
			// thus, always call a controller method to operate on the data
			else {
				//use controller to store and retrieve from database
				LoginController controller = new LoginController();
				if (controller.login(model)) {
					// if credentials are correct, doGet homePage
					System.out.println("login successful");
					HomePageServlet servlet = new HomePageServlet();
					servlet.doGet(req, resp);
				} else {
					// if credentials wrong, give error
					errorMessage = "Incorrect password";
					System.out.println("login failed");
				}
			}
		} catch (NumberFormatException e) {
			errorMessage = "Invalid username or password";
		}
		
		// Add parameters as request attributes
		// this creates attributes named "first" and "second for the response, and grabs the
		// values that were originally assigned to the request attributes, also named "first" and "second"
		// they don't have to be named the same, but in this case, since we are passing them back
		// and forth, it's a good idea
		req.setAttribute("username", "username");
		req.setAttribute("password", "password");
		
		// add result objects as attributes
		// this adds the errorMessage text and the result to the response
		req.setAttribute("errorMessage", errorMessage);
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}

	// gets double from the request with attribute named s
	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return s;
		}
	}
}
