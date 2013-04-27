package com.manu.ypoll.attempts;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttempterRepository extends
		MongoRepository<Attempt, ObjectId> {

}
