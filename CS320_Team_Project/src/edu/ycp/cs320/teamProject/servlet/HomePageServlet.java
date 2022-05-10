package edu.ycp.cs320.teamProject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.teamProject.controller.HomePageController;

public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("HomePage Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/homePage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("HomePage Servlet: doPost");
		

		// holds the error message text, if there is any
		String errorMessage = null;
		String value = null;
		// decode POSTed form parameters and dispatch to controller
		try 
		{
			// check for errors in the form data before using is in a calculation
			value = getStringFromParameter(req.getParameter("value"));


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
			System.out.println(value);
		//setup logic for the buttons located on the right side of the home page to allow for 
		//easy movement across the pages
		if (value.equals("logOut"))
		{
			LoginServlet server = new LoginServlet();
			server.doGet(req, resp);
		}
		
		else if (value.equals("Profile"))
		{
			ProfileServlet server = new ProfileServlet();
			server.doGet(req, resp);
		}
		
		else if (value.equals("Job Comparison"))
		{
			JobComparisonServlet server = new JobComparisonServlet();
			server.doGet(req, resp);
		}
		else if (value.equals("Info Input")) {
			InfoInputServlet server = new InfoInputServlet();
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
