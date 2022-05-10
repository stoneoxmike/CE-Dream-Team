package edu.ycp.cs320.teamProject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.teamProject.derbyDatabase.Queries;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("SignUp Servlet: doGet");
		
		req.getRequestDispatcher("/_view/signUp.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Sign Up Servlet: doPost");

		// holds the error message text, if there is any
		String errorMessage = null;
		String value = null;
		String username = null;
		String password = null;
		String secondPassword = null;
		// decode POSTed form parameters and dispatch to controller
		try 
		{
			// check for errors in the form data before using is in a calculation
			value = getStringFromParameter(req.getParameter("value"));
			username = getStringFromParameter(req.getParameter("username"));
			password = getStringFromParameter(req.getParameter("password"));
			secondPassword = getStringFromParameter(req.getParameter("confirmPassword"));
			
			if (username == null)
			{
				errorMessage = "Please enter a new username";
				
				req.setAttribute("errorMessage", errorMessage);
				req.setAttribute("username", "username");
				doGet(req,resp);
			}
			else if (password == null)
			{
				errorMessage = "Please enter a new Password";
				
				req.setAttribute("errorMessage", errorMessage);
				
				req.setAttribute("password", "password");
				doGet(req, resp);
			}
			else if (secondPassword == null || !secondPassword.equals(password))
			{
				errorMessage = "Passwords are not the same";
				
				req.setAttribute("confirmPassword", "confirmPassword");
				req.setAttribute("errorMessage",  errorMessage);
				
				doGet(req, resp);
			} else
			{
				//logic to insert the new info into the database
				Queries query = new Queries();
				int result = query.insertUser(username, password);
				if(result == 1)
				{
					LoginServlet server = new LoginServlet();
					server.doGet(req, resp);
				}
				else
				{
					errorMessage = "interruption inputing information";
					req.setAttribute("errorMessage", errorMessage);
					doGet(req, resp);
				}
			}
			
			if (value == null)
			{
				// add result objects as attributes
				// this adds the errorMessage text and the result to the response
				req.setAttribute("errorMessage", errorMessage);
				//add submit object as attributes
				req.setAttribute("value", "value");
				doGet(req, resp);
			}
			// must create the controller each time, since it doesn't persist between POSTs
			// the view does not alter data, only controller methods should be used for that
			// thus, always call a controller method to operate on the data
			
			
		//setup logic for the buttons located on the right side of the home page to allow for 
		//easy movement across the pages
		if (value.equals("back"))
		{
			LoginServlet server = new LoginServlet();
			server.doGet(req, resp);
		}
		else {
			errorMessage = null;
			req.setAttribute("submit", "submit");
			req.setAttribute("errorMessage", errorMessage);
			// Forward to view to render the result HTML document
			doGet(req, resp);
		}
	}
		 catch (NumberFormatException e) {
				errorMessage = "Invalid request";
			}
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