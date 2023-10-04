package com.database;

import com.database.Usergetset;

public class Usergetset 
{
	public static String email;
	public static int taskid;
	public static String rname;
	public static String rname1;
  public static void setid(String email)
  {
	  Usergetset.email=email;
  }
  public static String getid()
  {
	 return email;
  }
  public static void settid(int taskid)
  {
	  taskid=taskid;
  }
  public static int gettid()
  {
	  return taskid;
  }
  public static void setrname(String rname)
  {
	  rname=rname;
  }
  public static String getrname()
  {
	  return rname;
  }
  public static void setrname1(String rname)
  {
	  rname1=rname;
  }
  public static String getrname1()
  {
	  return rname1;
  }

}
