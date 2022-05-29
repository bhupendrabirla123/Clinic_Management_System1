package com.cms.utility;

import java.sql.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Getconnection {

	public Connection getcon() {
		Connection connection = null;
		try {

			FileInputStream file = new FileInputStream("src/com/cms/utility/Cnfig.properties");
			Properties prop = new Properties();
			prop.load(file);
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String driver = prop.getProperty("driver");
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			System.out.println("Driver Class not found");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("");
		} catch (SQLException e) {

		}
		return connection;
	}

	public Statement getstatement() {
		Statement statement = null;
		try {
			statement = getcon().createStatement();
			return statement;
		} catch (SQLException e) {

		}
		return statement;
	}

	public static Connection getconnection1() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

		Properties prop = new Properties();
		String url = null;
		String username = null;
		String password = null;
		try (FileInputStream file = new FileInputStream("src/com/cms/dao/Cnfig.properties")) {

			prop.load(file);
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			return connection;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
