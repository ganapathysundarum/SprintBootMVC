package com.product.app.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.product.app.exception.ProductNotFoundException;
import com.product.app.jpa.ProductRepository;
import com.product.app.model.Product;

@RestController
public class ProductResource {

	@Autowired
	private ProductRepository repository;
	
	@GetMapping(value="/list-products")
	public List<Product> retrieveProducts(){
		return repository.findAll();
	}
	
	@PostMapping(value="/list-products")
	public ResponseEntity<Object> createProduct(@RequestBody Product product){
		Product createdProd = repository.save(product);
		
		if(createdProd == null) {
			return ResponseEntity.noContent().build();
		}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(createdProd.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/products/{id}")
	public Optional<Product> retrieveProduct(@PathVariable long id) {
		
		Optional<Product> product = repository.findById(id);
		
		if(!product.isPresent()) {
			throw new ProductNotFoundException("Product id id-"+id+" not found");
		}
				
		return product;
	}
	
	@DeleteMapping(value="/delete-products/{id}")
	public Optional<Product> deleteProduct(@PathVariable long id) {
		
		Optional<Product> product = repository.findById(id);
		
		if(!product.isPresent()) {
			throw new ProductNotFoundException("Product id id-"+id+" not found");
		}
				
		repository.deleteById(id);
		
		return product;
		
	}
	
		
	
	
}
