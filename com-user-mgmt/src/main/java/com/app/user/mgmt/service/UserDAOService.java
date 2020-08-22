package com.app.user.mgmt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.app.user.mgmt.model.User;

@Component
public class UserDAOService {
	
	public static long userCount=4;
	
	static List<User> userList= new ArrayList<User>();
	
	static {
		userList.add(new User(new Long("1001"),"Test1",new Date()));
		userList.add(new User(new Long("1002"),"Test2",new Date()));
		userList.add(new User(new Long("1003"),"Test3",new Date()));
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		userList.add(user);
		return user;
	}
	
	public List<User> findAll(){
		return userList;
	}	
	
	public User findUser(Long id) {
		for(User user:userList) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(Long id) {
		Iterator<User> itr = userList.iterator();
		while(itr.hasNext()) {
			User usr=(User)itr.next();
			if(usr.getId() == id) {
				itr.remove();
				return usr;
			}
		}		
		return null;
	}
	
}
