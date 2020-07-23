package com.vuavent.bookmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vuavent.bookmanager.bo.Book;
import com.vuavent.bookmanager.dbconnection.ConnectionFactory;

public class BookDAO {
	
	public Book findById(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM books WHERE id=" + id;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Book bookFind = (convertToBook(resultSet));
				return bookFind;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateBook(int id,  String name, String author, String publisher, 
							String type,String language, int quantity, String image) {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "UPDATE books set name ='" + name 
					+ "', author ='" + author 
					+ "', publisher = '" + publisher 
					+ "', type ='" + type 
					+ "', language='" + language 
					+ "', quantity = '" + quantity 
					+ "', image = '" + image 
					+ "'" +  " WHERE id = " + id ;
			System.out.println(sql);
			statement = connection.createStatement();
			statement.executeUpdate(sql);

			
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void insertBook( String name, String author, String publisher, 
							String type,String language, int quantity,  String image) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {	
			connection = ConnectionFactory.getConnection();
			String insertSQL = "INSERT INTO books (name,author,publisher,type,language,quantity, image)"
							+ " VALUES (?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, author);
			preparedStatement.setString(3, publisher);
			preparedStatement.setString(4, type);
			preparedStatement.setString(5, language);
			preparedStatement.setInt(6, quantity);
			preparedStatement.setString(7, image);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
		
	public void deleteBook(int id) {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "DELETE FROM books WHERE id=" + id;
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Book> searchByName(String textSearch) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Book> bookListSearch = new ArrayList<Book>();

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM books WHERE name='" + textSearch + "'";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				bookListSearch.add(convertToBook(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookListSearch;
	}

	
	public ArrayList<Book> getAllBook() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Book> bookList = new ArrayList<Book>();

		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM books";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				bookList.add(convertToBook(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}

	private static Book convertToBook(ResultSet rs) throws SQLException {
		Book book = new Book();

		book.setId(rs.getInt(1));
		book.setName(rs.getString(2));
		book.setAuthor(rs.getString(3));
		book.setPublisher(rs.getString(4));
		book.setType(rs.getString(5));
		book.setLanguage(rs.getString(6));
		book.setQuantity(rs.getInt(7));
		book.setImage(rs.getString(8));

		return book;
	}

}
