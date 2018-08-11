package org.mongo.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@ComponentScan(basePackages = "org.mongo.controller")
@Document(collection = "#{userRepository.getCollectionName()}")
//@Document
public class User {
    @Id
    private String id;
    
    private String name;
    
    private int age;
    
    public User() {
    	
    }
    
    public User(String name , int age ) {
    	this.name =  name;
    	this.age = age;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
