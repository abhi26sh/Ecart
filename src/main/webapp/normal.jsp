<%--
  Created by IntelliJ IDEA.
  User: abhi0
  Date: 25-04-2022
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.abhi.entities.Users" %>
    <%
        Users user= (Users)session.getAttribute("curr_user");

        if(user==null)
        {
            session.setAttribute("message","you are not loggedin login first");
            response.sendRedirect("login.jsp");
        }else{
            if(user.getUserType().equals("normal")){
                session.setAttribute("message","you are not authorized to access admin page ");
                response.sendRedirect("login.jsp");
            }else if(user.getUserType().equals("admin")){



            }else{

            }
        }
    %>