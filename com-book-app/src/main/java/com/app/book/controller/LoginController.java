package com.app.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.book.service.LoginService;

@Controller
@SessionAttributes("borrower")
public class LoginController {

	@Autowired
	private LoginService service;
			
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginBookApp() {		
		return "hello";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String welcomeBookApp(@RequestParam String borrower,
			@RequestParam String password,
			ModelMap model) {
	
		boolean isValidUser = service.validateUser(borrower, password);
		
		if (!isValidUser) {           
            model.put("errorMessage", "Invalid Credentials!!");
            return "hello";
        }
		
		 model.put("borrower", borrower);
		 model.put("password", password);
         return "welcome";
	}
	
}
