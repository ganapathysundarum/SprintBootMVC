package com.app.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.book.model.Book;
import com.app.book.service.BookService;

@RestController
public class BookRestController {
	
	@Autowired
	private BookService service;

	@RequestMapping(value="/rest/books", method=RequestMethod.GET)
	public List<Book> listAllBooks(){
		List<Book> listOfBooks = service.retrieveBooks("Gana");
		return listOfBooks;
	}
	
	
	@RequestMapping(value = "/rest/books/{id}", method = RequestMethod.GET)
    public Book retrieveTodo(@PathVariable("id") int id) {
        return service.retrieveBook(id);
	}
	
}
