package com.product.app.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.app.exception.ProductNotFoundException;
import com.product.app.jpa.ProductRepository;
import com.product.app.model.Product;

@Repository
@Transactional
public class ProductDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ProductRepository repository;
	
	public long insert(Product product) {
		entityManager.persist(product);
		return product.getId();
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	public Optional<Product> readProduct(long id) {
		Optional<Product> prod = repository.findById(id);
		
		if(prod == null) {
			throw new ProductNotFoundException("Product id id-"+id+" not found");
		}
		
		return prod;
	}
	
	public Optional<Product> deleteProduct(long id){
		
		Optional<Product> prod = repository.findById(id);
		
		if(prod == null) {
			throw new ProductNotFoundException("Product id id-"+id+" not found");
		}
		
		repository.deleteById(id);
		
		return prod;
		
	}
	
	public Optional<Product> updateProduct(Product product){
		
		Optional<Product> prod = repository.findById(product.getId());
		
		if(prod == null) {
			throw new ProductNotFoundException("Product id-"+product.getId()+" not found");
		}
		
		repository.delete(product);
		repository.save(product);
		
		return prod;
		
	}
	
	
}
