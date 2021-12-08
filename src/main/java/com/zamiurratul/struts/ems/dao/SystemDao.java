package com.zamiurratul.struts.ems.dao;

import java.sql.*;

public class SystemDao {
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "root", "");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public int registerEmployee(Long employeeId, String fullName, String email, String contactNo, String designation, Date joiningDate) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO EMPLOYEES (employeeId, fullName, email, contactNo, designation, joiningDate) VALUES (?,?,?,?,?,?)";
			PreparedStatement statement = getConnection().prepareStatement(sql);
			statement.setLong(1, employeeId);
			statement.setString(2, fullName);
			statement.setString(3, email);
			statement.setString(4, contactNo);
			statement.setString(5, designation);
			statement.setDate(6, joiningDate);
			i = statement.executeUpdate();
			System.out.println("SYSTEM DAO :: INSERT :: i " + i);
			return i;
		} catch (Exception ex) {
			ex.printStackTrace();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
}
