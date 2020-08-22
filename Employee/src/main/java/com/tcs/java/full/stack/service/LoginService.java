package com.tcs.java.full.stack.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.tcs.java.full.stack.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoginService {	
	
	@Value("${db.path}")
	private String accessFilePath;
	
	public boolean validateUser(String userName,String password,ModelMap model) throws Exception{
		String sql = "select emp_id from LoginControl  where login_name=? and password=?";
		System.out.println(sql);
		Connection con = getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);        
         
        ResultSet rs = preparedStatement.executeQuery();
        String empId = "";
        while(rs.next()){
        	empId = rs.getString("emp_id");
        }
        
        model.put("empId", empId);
        
		if(null != empId && empId.trim().length() > 0){
			return true;
		}
		//return userName.equalsIgnoreCase("Gana") && password.equalsIgnoreCase("12345");
        return false;
	}
	
	public List<Employee> retrieveEmployee(String empId){
		List<Employee> empList = null;
		try{
			
			String sql = "select * from employee_master  where emp_id=?";
			System.out.println(sql);
			Connection con = getConnection();
			
			PreparedStatement preparedStatement = con.prepareStatement(sql);
	        preparedStatement.setLong(1, Long.parseLong(empId));	             	         
	        ResultSet rs = preparedStatement.executeQuery();
	        ArrayList<Employee> empSet = new ArrayList<Employee>();	        
	        while(rs.next()){
	        	Employee emp = new Employee();
	        	emp.setEmpId(rs.getString("emp_id"));
	        	emp.setEmpFName(rs.getString("emp_name_first"));
	        	emp.setEmpMName(rs.getString("emp_name_last"));
	        	emp.setEmpLName(rs.getString("emp_name_middle"));
	        	emp.setEmpDOB(rs.getString("emp_dob"));
	        	emp.setEmpSex(rs.getString("sex"));
	        	emp.setEmpDOJ(rs.getString("emp_doj"));
	        	emp.setEmpBaseBranch(rs.getString("emp_base_branch"));
	        	emp.setEmpLocation(rs.getString("emp_location"));
	        	empSet.add(emp);
	        	System.out.println(emp.toString());
	        }
	        
	        empList = empSet;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return empList;
	}
	
	private Connection getConnection(){
		Connection con = null;
		String databaseURL = "jdbc:ucanaccess://"+accessFilePath;
		
		try{
			con = DriverManager.getConnection(databaseURL);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
}
