package com.javante.expense.demouser.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfiguration {
	
	@Value("${spring.data.mongodb.host}")
	private String hostName;
	@Value("${spring.data.mongodb.port}")
	private int port;
	@Value("${spring.data.mongodb.database}")
	private String dbName;

	@Bean
	public MongoDbFactory mongoDbFactory() {
		MongoClient mongoClient = new MongoClient(hostName, port);
		return new SimpleMongoDbFactory(mongoClient, dbName);
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoDbFactory());
	}

}
