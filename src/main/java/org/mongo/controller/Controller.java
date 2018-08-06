package org.mongo.controller;

import org.mongo.model.User;
import org.mongo.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping( value = "/start")
	public String start() {
		
		return "OK!!" ;
	}
	
	
	@PostMapping( value = "/addUser")
	public String addUser(@RequestBody User user) {
		
		System.out.println("User Name : " + user.getName());
	    System.out.println("User Age :" + user.getAge());
		
	    userRepo.save(user);
	    
		return "User Added";
	}
}
