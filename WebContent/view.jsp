<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.database.Dbconnection" %>
    <%@page import="com.database.Usergetset" %>
    <%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Remainder</title>
 <style>
 *{
      background-color: rgb(93, 76, 94);
    }
    table {
      margin-top: 120px;
      width: 100%;
      border-collapse: collapse;
    }
    

    th, td {
      padding: 8px;
      text-align: left;
      border-bottom: 2px solid #131212;
    }

    th {
      background-color: #055c08;
      color: white;
    }

    tr:nth-child(even) {
      background-color: #ddcfcf;
    }
  </style>
</head>
<body>
      <%Connection cn=Dbconnection.connect();
   String email=Usergetset.getid();
   PreparedStatement stmt=cn.prepareStatement("select *from remainder where email=?");
   stmt.setString(1,email);//ask user for id but at backend use email to show table of user
   ResultSet rs=stmt.executeQuery();
   %>
   <table>
    <tr>
      <th>Task Id</th>
      <th>Remainder Title</th>
      <th>Remainder Detail</th>
      <th>Date</th>
      <th>Status</th>
    </tr>
     <% while(rs.next()){%>
      <tr><td><%= rs.getInt(3) %></td>
             <td><%= rs.getString(4) %></td>
             <td><%= rs.getString(5) %></td>
             <td><%= rs.getString(6) %></td>
             <td><%= rs.getString(7) %></td>
         </tr>
         <tr><%} %></tr>
         
  </table>
  <br>
  <br>
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