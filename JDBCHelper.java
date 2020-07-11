package com.uttara.contact.amogh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCHelper {
	private static Connection con;
public static Connection getConnection()
{
	
	try {
		Class.forName(Constants.HSQL_DRIVER);
		con=DriverManager.getConnection(Constants.HSQL_URL);
		return con;
	} 
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
public static PreparedStatement getStatement(String sql)
{

	try {
		PreparedStatement ps=JDBCHelper.getConnection().prepareStatement(sql);
		return ps;
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
public static void closeResultSet(ResultSet rs)
{
	if(rs!=null)
	try {
		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void closePreparedStatement(PreparedStatement ps)
{
	if(ps!=null)
	try {
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void closeConnection(Connection con)
{
	if(con!=null)
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
