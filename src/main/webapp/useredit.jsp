

<!-- admiinn page -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');



    /* Apply gray color to readonly input fields */
    input[readonly] {
        background-color: #f2f2f2; /* Light gray background */
        color: #888; /* Gray text color */
    }



*{
    box-sizing: border-box;
    margin: 0;
    padding: 0;
    font-family: 'Roboto';
}

body{
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color:#131832 ;
    overflow: hidden;
    
}

.container{
    position:relative;
    width: 400px;
    background-color: #FFFDFF;
    border-radius: 4px;
    padding: 40px 20px 20px 20px;
}


input {border-top: none;
border-left: none;
border-right: none;
outline: none;
padding:0px 5px 5px 5px;
margin: 0 0 0 10px;
height: 25px;
flex: 1;
background-color: #FFFDFF;}



.input-group{
    display: flex;
    margin:20px 10px 10px 10px;
    position: relative;
    

}
label{
    width:80px;
    font-weight: 400;
    
}

textarea {border-top: none;
    border-left: none;
    border-right: none;
    
flex:1;}

    button{
        display: block;
        margin:auto ;
        margin-top: 35px;
        margin-bottom:10px ;
        width:100px;
        height: 30px;
        background-color:#12172F ;
        color: #fff;
        border-radius: 4px;
        

    }

    .icon{
    position:absolute;
    top: -30px;
    left: calc( ( 420px - 60px ) / 2  ) ;
    background-color: #fff;
    height: 60px;
    width: 60px;
    display: flex;
    justify-content: center;
    align-items: center;

    border-radius: 50%;

    box-shadow: 1px 1px 2px #000 ;
    


    }


  #submit-error  {
    font-size: 13px;
    color :red;
  }</style>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
   
        
      
</head>
<body>
    <!-- userrrr -->
    <div class="container">
    
    
          <form action="" method="post">
            <div class="icon"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" viewBox="0 0 24 24" style="fill: rgba(0, 0, 0, 1);transform: ;msFilter:;"><path d="m2.6 13.083 3.452 1.511L16 9.167l-6 7 8.6 3.916a1 1 0 0 0 1.399-.85l1-15a1.002 1.002 0 0 0-1.424-.972l-17 8a1.002 1.002 0 0 0 .025 1.822zM8 22.167l4.776-2.316L8 17.623z"></path></svg></div>
           <div class=" mt-3">
        <c:if test="${not empty message}">
            <div class="alert ${messageType} alert-dismissible fade show" role="alert">
                ${message}
               
            </div>
        </c:if>
    </div>
           
            <div class="input-group">
                <label >First name</label>
                <input type="text" placeholder="Enter your first name" id="contact-name" name="firstName" value="${employee.firstName}"readonly>
                <span id="name-error"></span>
            </div>
            
            <div class="input-group">
                <label >Last name</label>
                <input type="text" placeholder="Enter your last name" id="contact-name"  name="lastName" value="${employee.lastName}" readonly>
                <span id="email-error"></span>
            </div>
            <div class="input-group">
                <label >Username</label>
				<input type="text" placeholder="Enter your username"  name="username" id="username"  value="${employee.userName} "readonly>
                <span id="message-error"></span>
            </div>
            <div class="input-group">
                <label >Adress</label>
				<input type="text" placeholder="Enter your adress"  name="address" id="adress"  value="${employee.address}" readonly>
                <span id="message-error"></span>
            </div>
             <div class="input-group">
                <label >Password</label>
				<input type="password" placeholder="Enter your password" name="password"   id="password" value="${employee.password}"readonly>
                <span id="password-error"></span>
            </div>
            <div class="input-group">
                <label >Phone No.</label>
                <input type="tel" placeholder="12 345 678" id="contact-phone" name="contact"   value="${employee.contact}" readonly>
                <span id="phone-error"></span>
            </div>
            
            <div class="input-group">
                
                <input type="hidden" placeholder="12 345 678" id="contact-phone" name="role"   value="${employee.role}"  readonly>
                <span id="phone-error"></span>
            </div>
             
            
                
                
               
            
            <button > <a href="Login.jsp" style="text-decoration: none; color: white;">logout</a></button>
            <span id="submit-error"></span>
            
        </form>
    </div>
    
</body>
</html>