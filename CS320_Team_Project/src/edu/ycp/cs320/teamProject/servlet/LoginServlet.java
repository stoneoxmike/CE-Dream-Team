package edu.ycp.cs320.teamProject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.teamProject.controller.LoginController;
import edu.ycp.cs320.teamProject.model.Login;
import edu.ycp.cs320.teamProject.storage.User;

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
		
		User model = new User();
		
		System.out.println("Login Servlet: doPost");
		

		// holds the error message text, if there is any
		String errorMessage = null;
		String value = null; 

		
		// decode POSTed form parameters and dispatch to controller
		try {
			model.setUsername(getStringFromParameter(req.getParameter("username")));
			model.setPassword(getStringFromParameter(req.getParameter("password")));

			// check for errors in the form data before using is in a calculation
			value = getStringFromParameter(req.getParameter("value"));
						
			// check for errors in the form data before using it in a calculation
			if (model.getUsername() == null) {
				errorMessage = "Please enter a username";
				// add result objects as attributes
				// this adds the errorMessage text and the result to the response
				req.setAttribute("errorMessage", errorMessage);
				// Add parameters as request attributes
				req.setAttribute("username", "username");
				req.setAttribute("password", "password");
				req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
			}
			else if (model.getPassword() == null)
			{
				errorMessage = "Please enter a password";
				// add result objects as attributes
				// this adds the errorMessage text and the result to the response
				req.setAttribute("errorMessage", errorMessage);
				
				// Add parameters as request attributes
				req.setAttribute("username", "username");
				req.setAttribute("password", "password");
				req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);

			}
			// otherwise, data is good,
			// must create the controller each time, since it doesn't persist between POSTs
			// the view does not alter data, only controller methods should be used for that
			// thus, always call a controller method to operate on the data
			else if (model.getUsername() != null && model.getPassword() != null){
				// add result objects as attributes
				// this adds the errorMessage text and the result to the response
				req.setAttribute("errorMessage", errorMessage);
				
				// Add parameters as request attributes
				req.setAttribute("username", "username");
				req.setAttribute("password", "password");
				System.out.println(model.getUsername() + ", " + model.getPassword());
				//use controller to store and retrieve from database
//				LoginController controller = new LoginController();
//				if (controller.login(model)) {
				if (model.login(model.getPassword()) && model.checkInfo()) {
					// if credentials are correct, doGet homePage
					System.out.println("login successful");
					HomePageServlet servlet = new HomePageServlet();
					servlet.doGet(req, resp);
				} else {
					// if credentials wrong, give error
					errorMessage = "Incorrect information";
					System.out.println("login failed");
					// add result objects as attributes
					// this adds the errorMessage text and the result to the response
					req.setAttribute("errorMessage", errorMessage);
					
					// Add parameters as request attributes
					req.setAttribute(model.getUsername(), "username");
					req.setAttribute("password", "password");
					req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
				}	
			}else 
			{
			if (value == null)
			{
				// add result objects as attributes
				// this adds the errorMessage text and the result to the response
				req.setAttribute("errorMessage", errorMessage);
				//add submit object as attributes
				req.setAttribute("value", "value");
				doGet(req, resp);
			}
			
			System.out.println(value);
			
			if(value.equals("Sign-Up Here") && errorMessage == null) {
			SignUpServlet server = new SignUpServlet();
			server.doGet(req, resp);
			}
		}
		} catch (NumberFormatException e) {
			errorMessage = "Invalid username or password";
		}
		
		
		// this creates attributes named "first" and "second for the response, and grabs the
		// values that were originally assigned to the request attributes, also named "first" and "second"
		// they don't have to be named the same, but in this case, since we are passing them back
		// and forth, it's a good idea
			
	}

	// gets string from the request with attribute named s
	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return s;
		}
	}
}