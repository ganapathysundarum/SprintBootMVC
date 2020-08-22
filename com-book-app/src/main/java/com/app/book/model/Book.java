package com.app.book.model;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

public class Book {

	private int id;
	private String borrower;
	
	@Size(min=10, message="Enter at least 10 characters ..!")
	private String bookName;
	
	private String bookAuthor;
	private String publisherName;
	private Date publishedDate;
	
	@Digits(fraction = 2, integer = 10, message="Enter valid number !")
	private double bookPrice;
	
	public Book() {
		super();
	}
	
	public Book(int id, String borrower, String bookName, String bookAuthor, String publisherName, Date publishedDate,
			double bookPrice) {
		super();
		this.id = id;
		this.borrower = borrower;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.publisherName = publisherName;
		this.publishedDate = publishedDate;
		this.bookPrice = bookPrice;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
		
	
	@Override
	public int hashCode() {
		return Objects.hash(bookAuthor, bookName, bookPrice, borrower, id, publishedDate, publisherName);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if(id != other.id) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", borrower=" + borrower + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor
				+ ", publisherName=" + publisherName + ", publishedDate=" + publishedDate + ", bookPrice=" + bookPrice
				+ "]";
	}
	
	
}
