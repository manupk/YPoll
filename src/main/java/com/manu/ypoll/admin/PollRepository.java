package com.manu.ypoll.admin;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.manu.ypoll.commons.Poll;

@Repository
public interface PollRepository  extends MongoRepository<Poll, ObjectId> {

}
