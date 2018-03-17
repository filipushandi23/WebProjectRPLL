<%-- 
    Document   : showCinemas
    Created on : Mar 17, 2018, 7:15:49 PM
    Author     : Filipus
--%>

<%@page import="model.Studio"%>
<%@page import="model.Cinema"%>
<%@page import="dao.CinemaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" cellpadding="5">
        <tr><td>NO</td><td>Cinema Name</td><td>Address</td><td>City</td><td>Province</td></tr>
        <%
            CinemaDAO _cinemaDAO = new CinemaDAO();
            ArrayList<Cinema> cinemas = _cinemaDAO.getAllCinema();
            
            for(int i=0;i<cinemas.size();i++){
                out.println("<tr>");
                out.println("<td>"+(i+1)+"</td>");
                out.println("<td>"+cinemas.get(i).getCinemaName()+"</td>");
                out.println("<td>"+cinemas.get(i).getAddress()+"</td>");
                out.println("<td>"+cinemas.get(i).getCity()+"</td>");
                out.println("<td>"+cinemas.get(i).getProvince()+"</td>");
                out.println("</tr>");
            }
        %>
    </table>
    </body>
</html>
