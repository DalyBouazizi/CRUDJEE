package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;

/**
 * Servlet implementation class Updateuser
 */
@WebServlet("/Updateuser")
public class Updateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateuser() {
        super();
        // TODO Auto-generated constructor stub
    }
    private EmployeeDao employeeDao;

    public void init() {
        employeeDao = new EmployeeDao();
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
		
		
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        String role = request.getParameter("role");
        
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUserName(username);
        employee.setPassword(password);
        employee.setContact(contact);
        employee.setAddress(address);
        employee.setRole(role);
        boolean check;

        try {
           check= employeeDao.editEmployee(employee);
           if (check) {
        	    // Set success message and message type attribute
        	    request.setAttribute("message", "Successfully changed");
        	    request.setAttribute("messageType", "alert-success");
        	} else {
        	    // Set error message and message type attribute if editEmployee returns false
        	    request.setAttribute("message", "An error occurred");
        	    request.setAttribute("messageType", "alert-danger");
        	}
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
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
     // Redirect to clientlist.jsp
        request.getRequestDispatcher("/clientslist.jsp").forward(request, response);
        
        
        
        
        
        
	}

}
