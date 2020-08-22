package com.app.user.mgmt.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.user.mgmt.model.User;

public interface UserRepository extends CrudRepository<User,Long>{
	List<User> findByName(String name);	
}

