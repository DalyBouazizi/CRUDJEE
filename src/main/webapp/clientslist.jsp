<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Client List</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
     <style>
        /* Your custom CSS styles */
        .justify-content-center {
            margin-top: 100px !important; /* Add margin above the button */
           } 
       body{
       background-color: #f6ebe7; /* Background color */
         }
    </style>
</head>
<body>
    <!-- Message div -->
    <div class="container mt-3">
        <c:if test="${not empty message}">
            <div class="alert ${messageType} alert-dismissible fade show" role="alert">
                ${message}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>
    </div>

    <h1>Client List</h1>
    
    <table class="table table-bordered">
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Username</th>
            <th>Password</th>
            <th>Contact</th>
            <th>Address</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
        <c:forEach var="client" items="${clientList}">
            <tr>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.userName}</td>
                <td>${client.password}</td>
                <td>${client.contact}</td>
                <td>${client.address}</td>
                <td>${client.role}</td>
                <td>
                    <form action="deleteClient" method="post">
                        <input type="hidden" name="numero" value="${client.contact}">
                        <input type="hidden" name="action" value="delete">
                        <input type="submit" class="btn btn-danger" value="Delete">
                    </form>
                    <form action="deleteClient" method="post">
                        <input type="hidden" name="numero" value="${client.contact}">
                        <input type="hidden" name="firstName" value="${client.firstName}">
                        <input type="hidden" name="lastName" value="${client.lastName}">
                        <input type="hidden" name="userName" value="${client.userName}">
                        <input type="hidden" name="password" value="${client.password}">
                        <input type="hidden" name="address" value="${client.address}">
                        <input type="hidden" name="role" value="${client.role}">
                        <input type="hidden" name="action" value="edit">
                        <input type="submit" class="btn btn-primary" value="Edit">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
        <!-- Button -->
   <div class=" d-flex justify-content-center">
    <form action="Addfromadmin" method="post">
        <button type="submit" class="btn btn-primary btn-md rounded-pill">Add Employee</button>
        <button class="btn btn-primary btn-md rounded-pill"> <a href="Login.jsp" style="text-decoration: none; color: white;">logout</a></button>
    </form>

    
  
    

    <!-- Include Bootstrap JS for closing alerts -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
