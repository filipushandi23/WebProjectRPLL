<%-- 
    Document   : showSeats
    Created on : Mar 28, 2018, 9:29:16 PM
    Author     : Filipus
--%>

<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page import="dao.SeatDAO"%>
<%@page import="model.Seat"%>
<%@page import="java.util.ArrayList"%>
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
                out.println("<h2>Seats Available for Studios : " + name + "</h2>");
                SeatDAO seatDAO= new SeatDAO();
                ArrayList<Seat> seatList = seatDAO.getSeatByStudioName(name);
                for (int idx = 0; idx < seatList.size(); idx++) {
                    if(idx%7==0){
                        out.println("<br>");
                    } 
                    out.println("<button>"+seatList.get(idx).getId().getSeatPosition()+"</button>");
                }
            }
        %>
    </body>
</html>
