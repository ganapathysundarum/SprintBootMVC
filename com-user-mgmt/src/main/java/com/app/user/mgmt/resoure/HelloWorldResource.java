package com.app.user.mgmt.resoure;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.user.mgmt.config.BasicConfiguration;
import com.app.user.mgmt.model.HelloWorldBean;

@RestController
public class HelloWorldResource {

	@Autowired
	private MessageSource messageSource; 

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	///hello-world/path-variable/in28minutes
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									LocaleContextHolder.getLocale());
	}
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@GetMapping(path = "/welcome")
	public String welcomeMessage() {
		return welcomeMessage;
	}
	
	@Autowired
	private BasicConfiguration config;
	
	@GetMapping(path = "/config")
	public Map readPropertyFromConfig() {		
		Map map = new HashMap();
		map.put("message",config.getMessage());
		map.put("number",config.getNumber());
		map.put("key",config.isValue());		
		return map;
	}
	
	
}
