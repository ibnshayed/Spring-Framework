package com.ibnshayed.www.config;

import com.ibnshayed.www.model.Product;
import com.ibnshayed.www.repository.ProductRepository;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.ibnshayed.www.repository")
@RequiredArgsConstructor
public class EmbeddedMongoDBConfigForProduct extends AbstractReactiveMongoConfiguration {

    private final Environment environment;

    @Override
    @Bean
    @DependsOn("embeddedMongoServer")
    public MongoClient reactiveMongoClient() {
        int port = environment.getProperty("local.mongo.port",Integer.class);
        return MongoClients.create(String.format("mongodb://localhost:%d",port));
    }

    @Override
    protected String getDatabaseName() {
        return "products";
    }



}
