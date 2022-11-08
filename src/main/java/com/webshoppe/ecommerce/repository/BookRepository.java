package com.webshoppe.ecommerce.repository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webshoppe.ecommerce.entity.Book;
import com.webshoppe.ecommerce.exception.DataAccessException;
import com.webshoppe.ecommerce.jdbc.JdbcConnectionManager;

public class BookRepository {
	
	private final static String BOOK_FIND_ALL = "SELECT bid, title, bookdesc, bookprice FROM booksdetails";
	private final static String BOOK_FIND_BY_PRICE = BOOK_FIND_ALL + " WHERE bookprice BETWEEN ? AND ?";

	private JdbcConnectionManager jdbcConnectionManager;

	public BookRepository(JdbcConnectionManager jdbcConnectionManager) {
		this.jdbcConnectionManager = jdbcConnectionManager;
	}

	public List<Book> findAll() {

		try {

			final PreparedStatement findAllQuery = jdbcConnectionManager.getConnection().prepareStatement(BOOK_FIND_ALL);
			final ResultSet resultSet = findAllQuery.executeQuery();

			return add_BookObject_ToArraylist(resultSet);

		} catch (Exception e) {
			throw DataAccessException.instance("failed_to_retrieve_books");
		}

	}

	public List<Book> findByPrice(BigDecimal minimumPrice, BigDecimal maximumPrice) {

		try {

			final PreparedStatement findAllQuery = jdbcConnectionManager.getConnection().prepareStatement(BOOK_FIND_BY_PRICE);
			findAllQuery.setBigDecimal(1, minimumPrice);
			findAllQuery.setBigDecimal(2, maximumPrice);

			final ResultSet resultSet = findAllQuery.executeQuery();
		
			return add_BookObject_ToArraylist(resultSet);
			
		} catch (Exception e) {
			throw DataAccessException.instance("failed_to_retrieve_books_by_price");
		}
	}
	
	private List<Book> add_BookObject_ToArraylist(ResultSet resultSet){
		
		final List<Book> books = new ArrayList<>();

		try {
			while (resultSet.next()) {
				
				Book book = new Book(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getBigDecimal(4));
				books.add(book);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

}
