<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Center container horizontally and vertically */
       /* Center container horizontally and vertically */
       body{
       background-color: #f6ebe7; /* Background color */
       }
        .outer-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Center contents inside container */
        .inner-container {
            text-align: center;
            padding: 50px;
            border: solid black 2px;
            border-radius: 25px;
            background-color: #ffff; /* Background color */
        }

        /* Center contents inside container */
        .login-form {
            text-align: center;
        }

        /* Underline text */
        .underline-text {
            text-decoration: underline;
        }
        .formii{
        padding-top:20px;
        }
    </style>
</head>
<body>
   <div class="outer-container">
        <div class="inner-container">
            <h2>Login</h2>
            
            
            
            
    <div class="container mt-3">
        <c:if test="${not empty message}">
            <div class="alert ${messageType}  fade show" role="alert">
                ${message}
              
            </div>
        </c:if>
    </div>
            
            
            
            
            <form action="Logincheck" method="post" class="formii">
                <div class="mb-3">
                    <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                </div>
                <button type="submit" class="btn btn-primary">Login</button>
            </form>
            <p class="mt-3">
                Don't have an account? <span ><a href="Registration.jsp" class="underline-text">Sign up</a></span>.
            </p>
        </div>
    </div>
</body>
</html>
