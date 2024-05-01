package controller;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.EmployeeDao;
import model.Employee;


@WebServlet("/clientlist")
public class Clientlist extends HttpServlet {

    private EmployeeDao employeeDao;

    public void init() throws ServletException {
        employeeDao = new EmployeeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
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
    }
}
