package com.manu.ypoll.appconfig;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

@Configuration
@EnableMongoRepositories(basePackages = "com.manu.ypoll")
public class MongoConfig {
	
	@Bean
	public Mongo mongo() throws UnknownHostException, MongoException {
		Mongo mongo = new Mongo("127.0.0.1");
		return mongo;
	}

	@Bean
	public SimpleMongoDbFactory mongoDbFactory() throws UnknownHostException,
			MongoException {
//		UserCredentials userCredentials = new UserCredentials("dev", "devpassword");
		SimpleMongoDbFactory factory = new SimpleMongoDbFactory(mongo(), "ypoll"
//				,userCredentials				
			);
		factory.setWriteConcern(WriteConcern.SAFE);
		return factory;
	}

	@Bean
	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
		return new MongoTemplate(mongoDbFactory);
	}
}
