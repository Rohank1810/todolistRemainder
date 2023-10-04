package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection cn=Dbconnection.connect();
		int id=0;
		
		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		Usergetset.setid(email);
		int age=Integer.parseInt(request.getParameter("age"));
		try {
			PreparedStatement sign=cn.prepareStatement("insert into user values (?,?,?,?,?,?)");
			sign.setInt(1,id);
			sign.setString(2, name);
			sign.setString(3, contact);
			sign.setString(4, email);
			sign.setString(5, password);
			sign.setInt(6, age);
			int i=sign.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("Dashboard.html");
			}
			else
			{
				response.sendRedirect("index.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
