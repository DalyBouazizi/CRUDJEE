package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;

/**
 * Servlet implementation class deleteClient
 */
@WebServlet("/deleteClient")
public class deleteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;
	public void init() throws ServletException {
        employeeDao = new EmployeeDao();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteClient() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    //----------------------------------------------------------------
    
    private void deleteClient(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException {
        // Retrieve the client ID from the request
        int numero = Integer.parseInt(request.getParameter("numero"));
        
        
        // Write your logic to delete the client with the given ID
        try {
        	
            employeeDao.deleteClient(numero);
        } catch (ClassNotFoundException e) {
            // Handle the ClassNotFoundException
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database driver not found");
            return;
        }
        
        
        
        // Redirect back to the client list page after deletion
        response.sendRedirect(request.getContextPath() + "/clientlist");
    }
    


  //----------------------------------------------------------------
    
    private void editClient(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException {
        // Retrieve the client ID from the request
        int numero = Integer.parseInt(request.getParameter("numero"));
        String contact = (request.getParameter("numero"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String role = request.getParameter("role");
        
        Employee employee = new Employee();
        
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUserName(userName);
        employee.setPassword(password);
        employee.setContact(contact);
        employee.setAddress(address);
        employee.setRole(role);
        
        request.setAttribute("employee", employee);
        
        
        // Redirect back to the client list page after deletion
        request.getRequestDispatcher("/edituser.jsp").forward(request, response);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    //----------------------------------------------------------------
    
    
    
    
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
		
		 // Check if the request is for deleting or editing a client
	    String action = request.getParameter("action");
	    
	    if (action != null) {
	    	
	        switch (action) {
	        
	            case "delete":
	                try {
	                    deleteClient(request, response);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    // Handle other exceptions here or redirect to an error page
	                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while deleting the client");
	                }
	                break;
	            case "edit":
	                try {
	                    editClient(request, response);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    // Handle other exceptions here or redirect to an error page
	                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while editing the client");
	                }
	                break;
	            default:
	                response.sendRedirect(request.getContextPath() + "/clientlist");
	                break;
	        }
	    } else {
	        response.sendRedirect(request.getContextPath() + "/clientlist");
	    }
		
		
		
	}

}
