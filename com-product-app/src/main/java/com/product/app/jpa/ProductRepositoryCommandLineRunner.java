package com.product.app.jpa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.product.app.model.Product;

@Component
public class ProductRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = 
			LoggerFactory.getLogger(ProductRepositoryCommandLineRunner.class);
	
	@Autowired
	private ProductRepository prodRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Product product = new Product("Wheat Bread", "Bakery", "Brittannia", 45.00, 1, "pkt",
				new Date(), new Date());
		prodRepository.save(product);
		log.info("New product created : "+product.toString());
		
		Optional<Product> extractedProduct = prodRepository.findById(1L);
		log.info("Product is retrived : " + extractedProduct);

		List<Product> products = prodRepository.findAll();
		log.info("All Users : " + products);
		
	}

	
	
}
