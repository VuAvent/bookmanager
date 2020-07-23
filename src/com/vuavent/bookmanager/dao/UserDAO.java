package com.vuavent.bookmanager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.vuavent.bookmanager.bo.User;
import com.vuavent.bookmanager.dbconnection.ConnectionFactory;

public class UserDAO {

	public void insertUser(String username, String password) {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "INSERT INTO users (username, password, role)"
						+" VALUES ('" 
						+ username + "', md5('"
						+ password + "'), 'user')";
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isUsernameExists(String username) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM users WHERE username='" + username + "'";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public User findByUsernameAndPassword(String username, String password) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM users WHERE username='" + username + "' AND password = md5('" + password + "')";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				User user = new User();
				user = convertToUser(resultSet);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static User convertToUser(ResultSet rs) throws SQLException {
		User user = new User();

		user.setId(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setRole(rs.getString(4));

		return user;
	}
}
