package edu.ycp.cs320.teamProject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.teamProject.controller.InfoInputController;
import edu.ycp.cs320.teamProject.model.InfoInput;
import edu.ycp.cs320.teamProject.storage.Information;

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
		
		//InfoInput model = new InfoInput();
		
		System.out.println("InfoInput Servlet: doPost");

		//InfoInputController controller = new InfoInputController();
		
		// assign model reference to controller so that controller can access model
		//controller.setModel(model);
		
		String errorMessage = null;
		String value = null;
			
			try 
			{
				// check for errors in the form data before using is in a calculation
				value = getStringFromParameter(req.getParameter("Submit"));


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
			
			if(value.equals("submit")) {
				HomePageServlet server = new HomePageServlet();
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
		
		// now call the JSP to render the new page
		req.getRequestDispatcher("/_view/infoInput.jsp").forward(req, resp);
	}


	// gets double from the request with attribute named s
		private String getStringFromParameter(String s) {
			if (s == null || s.equals("")) {
				return null;
			} else {
				return s;
			}
		}

	// gets an Integer from the Posted form data, for the given attribute name
	private int getInteger(HttpServletRequest req, String name) {
		return Integer.parseInt(req.getParameter(name));
	}
}
