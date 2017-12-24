package com.jalbum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jalbum.util.ConnectionManager;

public class GalleryDao {

	private final String SQL_GET_FIRST_IMAGE_ID = "select min(IMAGE_ID) from gallery";
	private final String SQL_GET_NEXT_IMAGE_ID = "select min(IMAGE_ID) from gallery where IMAGE_ID > ?";
	private final String SQL_GET_PREV_IMAGE_ID = "select max(IMAGE_ID) from gallery where IMAGE_ID < ?";
	private final String SQL_GET_IMAGE_CONTENT = "select CONTENT from gallery where IMAGE_ID = ?";
	
	private ConnectionManager connectionManager;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public GalleryDao() {
		connectionManager = ConnectionManager.getInstance();
	}
	
	public Integer getFirstImageID() {
		Integer targetImageID = 0;
		try {
			connection = connectionManager.getConnection();
			preparedStatement = connection.prepareStatement(SQL_GET_FIRST_IMAGE_ID);
			resultSet = preparedStatement.executeQuery();
			if(resultSet != null && resultSet.next()) {
				targetImageID = resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//connectionManager.closeResources(resultSet, preparedStatement, connection);
		}
		
		return targetImageID;
	}
	
	
	public Integer getNextImageID(Integer currentImageID) {
		Integer targetImageID = 0;
		try {
			connection = connectionManager.getConnection();
			preparedStatement = connection.prepareStatement(SQL_GET_NEXT_IMAGE_ID);
			preparedStatement.setInt(1, currentImageID);
			resultSet = preparedStatement.executeQuery();
			if(resultSet != null && resultSet.next()) {
				targetImageID = resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//connectionManager.closeResources(resultSet, preparedStatement, connection);
		}
		
		return targetImageID;
	}
	
	public Integer getPreviousImageID(Integer currentImageID) {
		Integer targetImageID = 0;
		try {
			connection = connectionManager.getConnection();
			preparedStatement = connection.prepareStatement(SQL_GET_PREV_IMAGE_ID);
			preparedStatement.setInt(1, currentImageID);
			resultSet = preparedStatement.executeQuery();
			if(resultSet != null && resultSet.next()) {
				targetImageID = resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//connectionManager.closeResources(resultSet, preparedStatement, connection);
		}
		
		return targetImageID;
	}
	
	public byte[] getImageContent(Integer imageID) {
		byte[] targetImageContent = null;
		try {
			connection = connectionManager.getConnection();
			preparedStatement = connection.prepareStatement(SQL_GET_IMAGE_CONTENT);
			preparedStatement.setInt(1, imageID);
			resultSet = preparedStatement.executeQuery();
			if(resultSet != null && resultSet.next()) {
				targetImageContent = resultSet.getBytes(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//connectionManager.closeResources(resultSet, preparedStatement, connection);
		}
		
		return targetImageContent;
	}
}


