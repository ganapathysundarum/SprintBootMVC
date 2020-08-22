package com.product.app.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean validateUser(String userName,String password) {
		return userName.equalsIgnoreCase("Gana") && password.equalsIgnoreCase("12345");
	}

}
