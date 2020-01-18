package com.ibnshayed.www.controller;

import com.ibnshayed.www.model.Product;
import com.ibnshayed.www.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService service;

    @Test
    public void testAllProducts(){
        Flux<Product> productFlux = service.findAll();

        StepVerifier.create(productFlux)
                .thenAwait(Duration.ofHours(10))
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    public void testAProduct(){
        //Flux<Product> productFlux = service.findAll();

        Mono<Product> productMono = service.findById("1");

        StepVerifier.create(productMono)
                .thenAwait(Duration.ofHours(10))
                .expectNextCount(1)
                .verifyComplete();
    }
}
