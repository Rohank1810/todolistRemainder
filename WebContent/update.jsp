<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.database.Dbconnection" %>
    <%@page import="com.database.Usergetset" %>
    <%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Status update</title>
 <style>
    /* CSS styles for the table */
    *
    {
    background color:#E0EAFC;
    }
    
    
    table {
      border-collapse: collapse;
      width: 100%;
    }

    th, td {
      padding: 8px;
      text-align: left;
      border-bottom: 1px solid #500d0d;
    }

    tr:hover {
      background-color: #814d4d;
    }

    /* CSS styles for the buttons */
    .button {
      display: inline-block;
      padding: 6px 12px;
      background-color: #4CAF50;
      color: white;
      text-align: center;
      text-decoration: none;
      border: none;
      border-radius: 4px;
      font-size: 14px;
      cursor: pointer;
    }

    .button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
<table>
    <tr>
      <th>Task Id</th>
      <th>Remainder Title</th>
      <th>Remainder Detail</th>
      <th>Date</th>
      <th>Status</th>
    </tr>
  <%Connection cn=Dbconnection.connect();
   String email=Usergetset.getid();
   String rname=Usergetset.getrname();
   PreparedStatement stmt=cn.prepareStatement("select *from remainder where email=?");
   stmt.setString(1,email);//ask user for id but at backend use email to show table of user
   ResultSet rs=stmt.executeQuery();%>
		 <% while(rs.next()){%>
             <tr><td><%= rs.getInt(3) %></td>
             <td><%= rs.getString(4) %></td>
             <td><%= rs.getString(5) %></td>
             <td><%= rs.getString(6) %></td>
             <td><%= rs.getString(7) %></td> <br>
             
             
  <tr><%} %></tr>
 <% PreparedStatement stmtt=cn.prepareStatement("update remainder set rtitle=? where email=?");
   stmtt.setString(1,"completed");
   stmtt.setString(2,email);
 %>

         
         </table>
         <center>
             <button onclick="redirectToPage()"> Dashboard</button>
             </center>
         <script>
    function redirectToPage() {
      // Change "anotherpage.html" to the desired page's URL
      window.location.href = "Dashboard.html";
    }
  </script>
</body>
</html>