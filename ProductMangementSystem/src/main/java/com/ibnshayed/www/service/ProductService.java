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
        return this.productRepository.findAll()
                .switchIfEmpty(Flux.just());
    }

    // Update a Product
    public  Mono<Product> update(Product product){
        return this.productRepository.findById(product.getProductId())
                .flatMap(foundProduct -> {
                        foundProduct.setProductName(product.getProductName());
                        foundProduct.setProductQuantity(product.getProductQuantity());
                    return this.productRepository.save(foundProduct);
                });
    }

    // Delete a Product
    public Mono<Product> delete(String productId) {
        return this.productRepository.findById(productId)
                .flatMap(product -> this.productRepository.delete(product).thenReturn(product));

    }

    public Mono<Product> sellProduct(String productId){
        return this.productRepository.findById(productId)
                .flatMap(foundProduct -> {
                    if(foundProduct.getProductQuantity() > 0)
                        foundProduct.setProductQuantity(foundProduct.getProductQuantity() - 1);
                    return this.productRepository.save(foundProduct);
                });
    }


}
