package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;

/**
 * Servlet implementation class Logincheck
 */
@WebServlet("/Logincheck")
public class Logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	  private EmployeeDao employeeDao;

	    public void init() {
	        employeeDao = new EmployeeDao();
	    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        	
	        try {
	        	 // Call the DAO method to check login and get user details
	            String[] userDetails = employeeDao.checkLogin(username,password);
	           
	           // for (String detail : userDetails) {
	             //   System.out.println(detail);
	          //  }
	            if (userDetails[7] != null) { // Check if the role is not null
	                String role = userDetails[7]; // Get the role from the userDetails array
	                
	                // Check the role and redirect accordingly
	                if ("admin".equals(role)) {
	                    // Redirect to admin page
	                	  List<Employee> clientList = null;
	                      try {
	                          // Retrieve list of clients from the database
	                          clientList = employeeDao.getAllClients();
	                      } catch (ClassNotFoundException e) {
	                          // Handle the ClassNotFoundException
	                          e.printStackTrace(); // Consider logging the exception instead
	                          response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database driver not found");
	                          return; // Return to avoid further processing
	                      }

	                      // Set the list as an attribute in the request object
	                      request.setAttribute("clientList", clientList);

	                      // Forward the request to the JSP file
	                      RequestDispatcher dispatcher = request.getRequestDispatcher("clientslist.jsp");
	                      dispatcher.forward(request, response);
	                } else if ("user".equals(role)) {
	                    // Redirect to user page
	                	Employee employee = new Employee();
	                    employee.setFirstName(userDetails[1]);
	                    employee.setLastName(userDetails[2]);
	                    employee.setUserName(userDetails[3]);
	                    employee.setPassword(userDetails[4]);
	                    employee.setContact(userDetails[5]);
	                    employee.setAddress(userDetails[6]);
	                    employee.setRole(userDetails[7]);
	                    request.setAttribute("employee", employee);
	                    // Redirect back to the client list page after deletion
	                    request.getRequestDispatcher("/useredit.jsp").forward(request, response);
	                } 
	                }else {
	                    // Redirect to other page (if role is neither admin nor user)
	                    request.setAttribute("message", "Invalid coordinates. Please try again.");
	                    request.setAttribute("messageType", "alert-danger");
	                    RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
	                    dispatcher.forward(request, response);
}}
	            catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
	}
	
	
	

}
