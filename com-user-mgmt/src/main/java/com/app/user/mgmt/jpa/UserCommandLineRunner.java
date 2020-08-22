package com.app.user.mgmt.jpa;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.user.mgmt.model.User;

@Component
public class UserCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory
            .getLogger(UserCommandLineRunner.class);
	
	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		repository.save(new User("Ganapathi",new Date()));
		repository.save(new User("Mallika",new Date()));
		repository.save(new User("Kesara",new Date()));
		repository.save(new User("Sumika",new Date()));
		
		log.info("-------------------------------");
        log.info("Finding all users");
        log.info("-------------------------------");
        for (User user : repository.findAll()) {
            log.info(user.toString());
        }
        
        log.info("____________________");
		for (User user : repository.findByName("Ganapathi")) {   
			log.info(user.toString());
		}
        		
		
	}

}
