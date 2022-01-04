package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker";
		String userName="hbstudent";
		String password="hbstudent";
		

		
		
		try {
			System.out.println("Connecting to jdbc server"+jdbcUrl);
			Connection connection=DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Connected Successfully....");
			
		} catch (Exception e) {
				e.printStackTrace();
		}

	}

}
