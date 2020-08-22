package com.app.user.mgmt.resoure;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.user.mgmt.exception.UserNotFoundException;
import com.app.user.mgmt.model.User;
import com.app.user.mgmt.service.UserDAOService;

@RestController
public class UserResource {
	
	@Autowired
	private UserDAOService service;
	
	@GetMapping("/users")
	public List<User> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findUser(@PathVariable Long id) {
		
		User extractedUser = service.findUser(id); 
		
		if(extractedUser == null) {
			throw new UserNotFoundException("id-"+id);
		}
		
		return extractedUser; 
	}
		

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {		
		
		User savedUser = service.save(user);
		
		if(savedUser == null) {
			return ResponseEntity.noContent().build();
		}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/delete-users/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		
		User extractedUser = service.findUser(id);
		
		if(extractedUser == null) {
			throw new UserNotFoundException("id-"+id);
		}
		
		service.deleteById(id);
		return "The User "+extractedUser.getName()+" has been deleted !";
	}
	
}
