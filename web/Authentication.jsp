<%-- 
    Document   : Authentication
    Created on : Jan 19, 2013, 12:33:18 PM
    Author     : S512746
--%>

<%@page import="Sustainability.Users"%>
<%@page import="DAO.UsersDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String userName=request.getParameter("userName");
String password=request.getParameter("password");

UsersDAO user=new UsersDAO();
Users users=user.verifyCredentials(userName, password);



if(users!=null)
 {
session.setAttribute("user",userName);
session.setAttribute("role", users.getRole());
response.sendRedirect("Details.jsp"); // redirect to homepage if login is success
}
else
{
response.sendRedirect("Failure.html"); // redirect to index page if login fails.
} 

%>
