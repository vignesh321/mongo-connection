package org.mongo.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository( "userRepository")
public interface UserRepository extends MongoRepository<User, String>, UserRepositoryCustom{

	User findByName( String  name);
	
}
