package com.webshoppe.ecommerce.entity;

import java.math.BigDecimal;

public class Book {
	
	private String bookId;
	private	String title;
	private String bookDescription;
	private BigDecimal bookPrice;
	
	
	public Book(){
		
		
	}
	
	public Book(String bookId, String title, String bookDescription, BigDecimal bookPrice) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.bookDescription = bookDescription;
		this.bookPrice = bookPrice;
	}
	
	
	public String getBookId() {
		return bookId;
	}
	
	public String getTitle() {
		return title;
	}
	public String getBookDescription() {
		return bookDescription;
	}

	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	
	
	

}
