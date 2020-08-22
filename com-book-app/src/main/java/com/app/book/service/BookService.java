package com.app.book.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.book.model.Book;

@Service
public class BookService {
	
	private static List<Book> books = new ArrayList<Book>();
	private static int booksCount=3;
	
	static {		
		books.add(new Book(1,"Gana", "Core Java","ALex Gary","Tata McGraw Hill",new Date(),400));
		books.add(new Book(2,"Gana", "Programming in C","Dennis Ritchie","SilverLight",new Date(),200));
		books.add(new Book(3,"Gana", "Google Cloud in Action","Sathya Pratap","Google Pub Inc,",new Date(),1800));
	}
	
	
	public List<Book> retrieveBooks(String borrower){
		if(borrower == null) {
			borrower = "Gana";
		}
		List<Book> mybooks = new ArrayList<Book>();
		for(Book book:books) {
			if(book.getBorrower().equals(borrower)) {
				mybooks.add(book);
			}
		}
		return mybooks;
	}
	
	public void addNewBook(String borrower,String bookName, String bookAuthor, String publisherName, 
			Date publishedDate, double bookPrice) {
		books.add(new Book(++booksCount, borrower, bookName, bookAuthor, publisherName, publishedDate,
				bookPrice));
	}
	
	public void deleteBook(int id) {
		Iterator<Book> bookItr = books.iterator();
		while(bookItr.hasNext()) {
			Book myBook = bookItr.next();
			if(myBook.getId()==id) {
				bookItr.remove();
			}
		}				
	}
	
	public Book retrieveBook(int id) {
		for(Book book:books) {
			if(book.getId() == id) {
				return book;
			}
		}
		return null;
	}
	
	public void updateBook(Book book) {		
		books.remove(book);		
		books.add(book);			
	}
	
}
