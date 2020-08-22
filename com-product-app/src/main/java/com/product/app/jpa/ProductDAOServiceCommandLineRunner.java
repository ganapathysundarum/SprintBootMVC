package com.product.app.jpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.product.app.model.Product;
import com.product.app.service.ProductDAOService;

@Component
public class ProductDAOServiceCommandLineRunner implements CommandLineRunner {

	private static final Logger log = 
			LoggerFactory.getLogger(ProductDAOServiceCommandLineRunner.class);
	
	@Autowired
	private ProductDAOService service;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Product product = new Product("Apple", "Fruits", "AustralianX", 200.00, 1, "Kg",
				new Date(), new Date());
		service.insert(product);
		log.info("New product is created : "+product.toString());
	}
		
}
