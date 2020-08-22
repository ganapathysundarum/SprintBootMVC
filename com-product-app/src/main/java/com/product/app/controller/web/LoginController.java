package com.product.app.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("username")
public class LoginController {

	@Autowired
	private com.product.app.service.LoginService service;
			
	@RequestMapping(value="/login-product",method=RequestMethod.GET)
	public String loginProductApp() {		
		return "login";
	}
	
	@RequestMapping(value="/login-product",method=RequestMethod.POST)
	public String welcomeProductApp(@RequestParam String username,
			@RequestParam String password,
			ModelMap model) {
	
		boolean isValidUser = service.validateUser(username, password);
		
		if (!isValidUser) {           
            model.put("errorMessage", "Invalid Credentials!!");
            return "login";
        }
		
		 model.put("username", username);
		 model.put("password", password);
         return "products";
	}
	
	@RequestMapping(value="/home-product",method=RequestMethod.GET)
	public String showHomePage() {		
		return "home";
	}
	
}
