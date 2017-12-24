package com.jalbum.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	private static ConnectionManager instance;
	private static Connection connection;
	private Properties props;
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	private ConnectionManager() {
		props = new Properties();
		try {
			props.load(this.getClass().getClassLoader().getResourceAsStream("database.properties"));
			driverClassName = props.getProperty("driverClassName");
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
			Class.forName(driverClassName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionManager getInstance() {
		if(instance == null) {
			synchronized (ConnectionManager.class) {
				if(instance == null) {
					instance = new ConnectionManager();
				}
			}
		}
		
		return instance;
	}
	
	public Connection getConnection() {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				System.out.println("\nCounld not create the connection ==> " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	
	public void closeResources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		
		try {
			
			if(resultSet != null) {
				resultSet.close();
			}
			
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			
			if(connection != null) {
				this.connection.close();
				connection.close();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
