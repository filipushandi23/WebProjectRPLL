<%-- 
    Document   : userLogin
    Created on : Apr 12, 2018, 3:20:25 PM
    Author     : Filipus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <table>
            <form action="loginServlet" method="post">
                <tr><td>Email:  </td><td><input type="text" name="email" required></td></tr>
                <tr><td>Password: </td><td><input type="password" name="password" required></td></tr>
                <tr><td><input type="submit" value="Login"></td></tr>
            </form>
        </table>
    </body>
</html>
