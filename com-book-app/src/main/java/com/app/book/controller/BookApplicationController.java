package com.app.book.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.book.model.Book;
import com.app.book.service.BookService;

@Controller
@SessionAttributes({"borrower","bookName","bookAuthor","publisherName","bookPrice"})
public class BookApplicationController {

	@Autowired
	private BookService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/list-books",method=RequestMethod.GET)
	public String showAllBooks(ModelMap model) {
		String borrower = getLoggedInBorrower(model);	    
		model.put("books", service.retrieveBooks(borrower));
		return "list-books";
	}
	
	@RequestMapping(value="/add-book",method=RequestMethod.GET)
	public String showAddBookPage(ModelMap model) {
		model.addAttribute("book", new Book(0, getLoggedInBorrower(model),
				(String)model.get("bookName"),
				(String)model.get("bookAuthor"),
				(String)model.get("publisherName"),
				new Date(),
				0));
		return "book";
	}
	
	@RequestMapping(value="/add-book",method=RequestMethod.POST)
	public String addBook(ModelMap model, @Valid Book book, BindingResult result) {
		
		if(result.hasErrors()) {
			return "book";
		}
		
		String borrower = getLoggedInBorrower(model);
		service.addNewBook(borrower, book.getBookName(), book.getBookAuthor(), book.getPublisherName(), book.getPublishedDate(), book.getBookPrice());
		return "redirect:/list-books";
	}
	
	@RequestMapping(value="/delete-book",method=RequestMethod.GET)
	public String deleteBook(@RequestParam int id) {
		service.deleteBook(id);
		return "redirect:/list-books";
	}
	
	@RequestMapping(value="/update-book",method=RequestMethod.GET)
	public String showUpdateBookPage(@RequestParam int id,ModelMap model) {
		Book book = service.retrieveBook(id);
		model.put("book",book);
		return "book";
	}
	
	@RequestMapping(value="/update-book",method=RequestMethod.POST)
	public String updateBook(@RequestParam int id,ModelMap model, @Valid Book book, BindingResult result) {
		
		if (result.hasErrors()) {
			return "book";
		}
		System.out.println("======> "+model.toString());
		Book updatedBook=(Book)model.get("book");		
		book.setBorrower(updatedBook.getBorrower());
		book.setBookName(updatedBook.getBookName());
		book.setBookAuthor(updatedBook.getBookAuthor());
		book.setBookPrice(updatedBook.getBookPrice());		
		book.setPublisherName(updatedBook.getPublisherName());
		book.setPublishedDate(updatedBook.getPublishedDate());
		
		service.updateBook(book);		
		
		return "redirect:/list-books";
	}	
	
	private String getLoggedInBorrower(ModelMap model) {
		//return (String) model.get("borrower");
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
}
