package com.example.demo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;

public class DAOUtility {

	private static String username;
	private static String password;
	private static String dbms;
	private static String serverName;
	private static String portNumber;
	private static String testerdb;
	
	private static boolean initialized = false;

	public static void initProperties(String filename) {
		Properties serverProps = new Properties();
		try (FileInputStream fis = new FileInputStream(filename)) {
			serverProps.load(fis);
			username = (String) serverProps.get("username");
			password = (String) serverProps.get("password");
			dbms = (String) serverProps.get("dbms");
			serverName = (String) serverProps.get("serverName");
			portNumber = (String) serverProps.get("portNumber");
			testerdb = (String) serverProps.getProperty("databaseName");
			initialized = true;
		} catch (FileNotFoundException e) {
			System.out.println("Filename Wrong");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		// TODO: Use an Object Pool here to manage connections
		if(!initialized)
		{
			initProperties("src/main/resources/static/mysql.properties");
		}
		Connection connection = null;
		Properties connProps = new Properties();
		connProps.put("user", username);
		connProps.put("password", password);
		//connection.
		connection = DriverManager
				.getConnection("jdbc:" + dbms + "://" + serverName + ":" + portNumber + "/", username, password);
		
		selectDatabase(testerdb, connection);
		
		return connection;
	}
	private static void selectDatabase(String databaseName, Connection connection)
	{
		String statement = "USE " + databaseName;
		try {
			connection.createStatement().execute(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
