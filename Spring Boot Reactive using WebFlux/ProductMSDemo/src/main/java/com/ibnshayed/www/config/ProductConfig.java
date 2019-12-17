package com.ibnshayed.www.config;


import com.ibnshayed.www.domain.Product;
import com.ibnshayed.www.repository.ProductRepository;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
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
public class ProductConfig extends AbstractReactiveMongoConfiguration {

    private final Environment environment;

    public ProductConfig(Environment environment){
        this.environment = environment;
    }

    @Override
    protected String getDatabaseName() {
        return "todos";
    }

    @Override
    @Bean
    @DependsOn("embeddedMongoServer")
    public MongoClient reactiveMongoClient() {
        int port = environment.getProperty("local.mongo.port", Integer.class);
        return MongoClients.create(String.format("mongodb://localhost:%d", port));
    }

    @Bean
    public CommandLineRunner insertAndView(ProductRepository repository, ApplicationContext context){
        return args -> {

            repository.save(new Product("1","name1",10)).subscribe();
            repository.save(new Product("2","name2",53)).subscribe();
            repository.save(new Product("3","name3",33)).subscribe();
            repository.save(new Product("4","name4", 11)).subscribe();

            repository.findAll().subscribe(System.out::println);
        };
    }
}
