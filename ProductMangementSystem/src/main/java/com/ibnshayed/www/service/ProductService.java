package com.ibnshayed.www.service;

import com.ibnshayed.www.exception.ResourceAlreadyExistsException;
import com.ibnshayed.www.exception.ResourceNotFoundException;
import com.ibnshayed.www.model.Product;
import com.ibnshayed.www.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // Create a new Product
    public Mono<Product> save(Product product){
        return this.productRepository.insert(product);
    }

    // Find Product By ProductId
    public Mono<Product> findById(String productId){
        return this.productRepository.findById(productId);

    }

    //Find All Product
    public Flux<Product> findAll(){
        return this.productRepository.findAll();
    }

    // Update a Product
    public  Mono<Product> update(){
        return null;
    }

    // Delete a Product
    public Mono<Void> delete(String productId) {
        return this.productRepository.deleteById(productId);

    }


}
