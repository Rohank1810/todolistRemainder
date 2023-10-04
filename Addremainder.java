package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addremainder
 */
public class Addremainder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addremainder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection cn=Dbconnection.connect();
		int id=0;
		int taskid =Integer.parseInt(request.getParameter("taskid"));
		String date=request.getParameter("date");
		String rtitle=request.getParameter("rtitle");
		String rdesc=request.getParameter("rdesc");
		String status=request.getParameter("r");
		String email=Usergetset.getid();
		Usergetset.setrname(rtitle);
		try {
		 	PreparedStatement st=cn.prepareStatement("insert into remainder values(?,?,?,?,?,?,?)");
			st.setInt(1, id);
			st.setString(2, email);
			st.setInt(3, taskid);
			st.setString(4, rtitle);
			st.setString(5, rdesc);
			st.setString(6, date);
			st.setString(7, status);
			int i=st.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("Add1.html");
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
