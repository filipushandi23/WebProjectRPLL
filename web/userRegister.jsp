<%-- 
    Document   : userRegister
    Created on : Apr 12, 2018, 4:07:09 PM
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
        <h1>Register</h1>
        <table>
            <form action="registerServlet" method="post">
                <tr><td>First Name</td><td><input type="text" name="firstName" required></td></tr>
                <tr><td>Last Name</td><td><input type="text" name="lastName" required></td></tr>
                <tr><td>Email</td><td><input type="text" name="email" required></td></tr>
                <tr><td>Password</td><td><input type="password" name="password" required></td></tr>
                <tr><td>Confirm Password</td><td><input type="password" name="confirm" required></td></tr>
                <tr><td>Profile Picture</td><td><input type="file" name="profile_picture" accept="image/*"></tr>
                <tr><td><input type="submit" value="Register"></td></tr>
            </form>
        </table>
    </body>
</html>
