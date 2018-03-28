<%-- 
    Document   : showStudios
    Created on : Mar 28, 2018, 9:17:15 PM
    Author     : Filipus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Studio"%>
<%@page import="dao.StudioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
            if (name != null || !name.equals("")) {
                out.println("<h2>Studio list for Cinema : " + name + "</h2>");
                StudioDAO studioDAO = new StudioDAO();
                ArrayList<Studio> studioList = studioDAO.getStudiosByCinemaName(name);
                out.println("<table border='1' cellpadding='5'>");
                out.println("<tr><td>Studio Number</td><td>Studio Name</td><td>Cols</td><td>Rows</td></tr>");
                for (Studio studio : studioList) {
                    out.println("<tr>");
                    out.println("<td>"+studio.getStudioNumber()+"</td>");
                    out.println("<td><a href='showSeats.jsp?name="+studio.getStudioName()+"'>"+studio.getStudioName()+"</a></td>");
                    out.println("<td>"+studio.getColCapacity()+"</td>");
                    out.println("<td>"+studio.getRowCapacity()+"</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            }
        %>
    </body>
</html>
