package com.tcs.java.full.stack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tcs.java.full.stack.service.LoginService;

@Controller
@SessionAttributes("empName")
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginEmployeeApp() {		
		return "Login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String welcomeEmployeeApp(@RequestParam String loginname,
			@RequestParam String password,
			ModelMap model) throws Exception {
	
		boolean isValidUser = service.validateUser(loginname, password, model);
		
		if (!isValidUser) {           
            model.put("errorMessage", "Invalid Credentials!!");
            return "Login";
        }
		
		 model.put("empname", loginname);
		 model.put("password", password);
         return "EmployeeDetails";
	}
	
	@RequestMapping(value="/list-employee",method=RequestMethod.GET)
	public String showEmployees(@RequestParam String employeeId,ModelMap model) {
		String empId = "";
		if(null != model && null != model.get("empId")){
			empId = model.get("empId").toString();
		}else{
			empId = employeeId.trim();
		}
		System.out.println("emp id : "+empId);
		model.put("employees", service.retrieveEmployee(empId));
		return "ListEmployee";
	}
	
}
