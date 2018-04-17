<%-- 
    Document   : showTest
    Created on : Mar 17, 2018, 12:49:25 PM
    Author     : Filipus
--%>

<%@page import="dao.ScheduleDAO"%>
<%@page import="model.Movie"%>
<%@page import="model.Schedule"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MovieDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" cellpadding="5">
            <tr><td>Title</td><td>Poster</td><td>Duration</td></tr>
            <%
                MovieDAO _movieDAO = new MovieDAO();
                ScheduleDAO _scheduleDAO = new ScheduleDAO();
                ArrayList<Movie> movies = _movieDAO.getAllMovie();
                ArrayList<Schedule> schedules = new ArrayList();

                for (int i = 0; i < movies.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + movies.get(i).getTitle() + "</td>");
                    out.println("<td><img src='" + movies.get(i).getPoster() + "' width='182px' height='268px'></td>");
                    out.println("<td> " + movies.get(i).getDuration() + "minutes </td>");
                    out.println("<td><ul>");
                    schedules = _scheduleDAO.getAll(movies.get(i).getMovieId());
                    for (int j = 0; j < schedules.size(); j++) {
                        out.println("<li>"+schedules.get(j).getId().getMovieStart()+"</li>");
                    }
                    out.println("</ul></td>");
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>
