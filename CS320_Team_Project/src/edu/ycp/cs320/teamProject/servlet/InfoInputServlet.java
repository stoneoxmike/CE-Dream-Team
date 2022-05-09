package edu.ycp.cs320.teamProject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.teamProject.controller.InfoInputController;
import edu.ycp.cs320.teamProject.model.InfoInput;
import edu.ycp.cs320.teamProject.storage.Job;

public class InfoInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("InfoInput Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/infoInput.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("InfoInput Servlet: doPost");
		
		// create GuessingGame model - model does not persist between requests
		// must recreate it each time a Post comes in 
		InfoInput model = new InfoInput();
		
		//holds error message text (not used right now) 
		int Ivalue = 0;
		String Svalue = null; 
		String errorMessage = null; 

		// create InfoInput controller - controller does not persist between requests
		// must recreate it each time a Post comes in
		InfoInputController controller = new InfoInputController();
		
		// assign model reference to controller so that controller can access model
		controller.setModel(model);
		
		try {
			
			//grabbing weights
			model.setsizeWeight(getInteger(req, req.getParameter("ddSize")));
			model.setageWeight(getInteger(req, req.getParameter("ddAge")));
			model.setcultureWeight(getInteger(req, req.getParameter("ddCulture")));
			model.setopportunityWeight(getInteger(req, req.getParameter("ddOpportunity")));
			model.setworkLifeBalanceWeight(getInteger(req, req.getParameter("ddWLBalance")));
			model.setsalaryWeight(getInteger(req, req.getParameter("ddSalary")));
			
			// check for errors in the form data before using is in a calculation
			Ivalue = getInteger(req, req.getParameter("value"));
			Svalue = getStringFromParameter(req.getParameter("value"));
			
			//if submit button pressed, go to homepage 
			if(Svalue.equals("submit")) {
				HomePageServlet server = new HomePageServlet();
				server.doGet(req, resp);
			}
			
			// add result objects as attributes
	
			// Add parameters as request attributes
			req.setAttribute("ddSize", "sizeWeight");
			req.setAttribute("ddAge", "ageWeight");
			req.setAttribute("ddCulture", "cultureWeight");
			req.setAttribute("ddOpportunity", "opportunityWeight");
			req.setAttribute("ddWLBalance", "workLifeBalanceweight");
			req.setAttribute("ddSalary", "salaryWeight");
			
			System.out.println(model.getsizeWeight() + ", " + model.getageWeight() + model.getcultureWeight() + ", " + model.getopportunityWeight() + ", " + model.getworkLifeBalanceWeight() + ", " + model.getsalaryWeight());

			//use controller to store and retrieve from database
//			LoginController controller = new LoginController();
//			if (controller.login(model)) {
			
//			if (model.login(model.getPassword())) {
//				// if credentials are correct, doGet homePage
//				System.out.println("login successful");
//				HomePageServlet servlet = new HomePageServlet();
//				servlet.doGet(req, resp);
//			} 
			
//			else {
//				// if credentials wrong, give error
//				errorMessage = "Incorrect password";
//				System.out.println("login failed");
//				// add result objects as attributes
//				// this adds the errorMessage text and the result to the response
//				req.setAttribute("errorMessage", errorMessage);
//				
//				// Add parameters as request attributes
//				req.setAttribute(model.getUsername(), "username");
//				req.setAttribute("password", "password");
//				req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
//			}
			
			// now call the JSP to render the new page
			req.getRequestDispatcher("/_view/infoInput.jsp").forward(req, resp);
		
		}
		
		//ignore for now 
		catch (NumberFormatException e) {
			errorMessage = "Invalid username or password";
		}
	
		}


	// gets an Integer from the Posted form data, for the given attribute name
	private int getInteger(HttpServletRequest req, String name) {
		return Integer.parseInt(req.getParameter(name));
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
