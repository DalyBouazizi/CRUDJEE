<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add user</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');
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

    .input-group span{
        position: absolute;
        font-size: 13px;
        right:0 ;
        bottom: 4px;
        color: red;

        
    }

  #submit-error  {
    font-size: 13px;
    color :red;
  }</style>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
   
        
      
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <div class="container">
          <form action="Adminadded" method="post">
            <div class="icon"><svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" viewBox="0 0 24 24" style="fill: rgba(0, 0, 0, 1);transform: ;msFilter:;"><path d="m2.6 13.083 3.452 1.511L16 9.167l-6 7 8.6 3.916a1 1 0 0 0 1.399-.85l1-15a1.002 1.002 0 0 0-1.424-.972l-17 8a1.002 1.002 0 0 0 .025 1.822zM8 22.167l4.776-2.316L8 17.623z"></path></svg></div>
            <div class="input-group">
                <label >First name</label>
                <input type="text" placeholder="Enter your first name" id="contact-name" name="firstName" onkeyup="validateName()">
                <span id="name-error"></span>
            </div>
            
            <div class="input-group">
                <label >Last name</label>
                <input type="text" placeholder="Enter your last name" id="contact-name"  name="lastName" onkeyup="validateName()">
                <span id="email-error"></span>
            </div>
            <div class="input-group">
                <label >Username</label>
				<input type="text" placeholder="Enter your username"  name="username" id="username" >
                <span id="message-error"></span>
            </div>
            <div class="input-group">
                <label >Address</label>
				<input type="text" placeholder="Enter your adress"  name="address" id="adress" >
                <span id="message-error"></span>
            </div>
             <div class="input-group">
                <label >Password</label>
				<input type="password" placeholder="Enter your password" name="password"   id="password" >
                <span id="password-error"></span>
            </div>
            <div class="input-group">
                <label >Phone No.</label>
                <input type="tel" placeholder="12 345 678" id="contact-phone" name="contact"  onkeyup="validatePhone()">
                <span id="phone-error"></span>
            </div>
            <div class="input-group">
              <label for="role">Role</label>
    <select class="form-control" id="role" name="role">
      <option value="admin">Admin</option>
      <option value="user">User</option>
    </select>
        </div>    
                
                
            
            <button onclick="validateForm(event)">Submit</button>
            <span id="submit-error"></span>
            
        </form>
    </div>
    
</body>
</html>