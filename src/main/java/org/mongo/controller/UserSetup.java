package org.mongo.controller;

import org.springframework.stereotype.Component;

@Component("userSetup")
public class UserSetup {
	
	public String collectionName;

	
	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	

}
