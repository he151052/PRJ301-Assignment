<%-- 
    Document   : login
    Created on : May 30, 2022, 12:06:46 AM
    Author     : oki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            *{
                font-family: sans-serif;
            }
            input[type="text"],input[type="password"]{
                width: 400px;
                height: 30px;
                padding-left: 15px;
                font-size: 20px;
            }
            input[type=submit]{              
                border: none;
                padding: 10px 20px;
                text-decoration: none;
                text-align: center;
                margin: 10px 150px;
                font-size: 20px;
            }
        </style>
    </head>
    <body>
        <div class="sign_in" style="width: 25%;margin: 50px  auto">
            <form action="login" method="POST">
                <h1 style="text-align: center;margin-bottom: 10px">Login</h1>
                
                <span style="font-size: 30px">Username</span> <br> 
                <input type="text" name="user"  placeholder="Enter username" required=""> <br> 
                <br>
                <span style="font-size: 30px">Password</span> <br> 
                <input type="password" name="pass" placeholder="Enter password" required="" /> <br>
                
                <input type="submit" value="Sign in">
            </form>
        </div>
    </body>
</html>
