package com.ibnshayed.www.service;

import com.ibnshayed.www.model.Product;
import com.ibnshayed.www.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Mono<Product> createProduct(Product product){
        return productRepository.save(product);
    }

    public Mono<Product> readOneProduct(String productId){
        return productRepository.findById(productId);
    }

    public Flux<Product> readAllProduct(){
        return productRepository.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono<Product> updateProduct(Product product){
        return null;
    }

    public Mono deleteProduct(String productId){
        return productRepository.deleteById(productId);
    }


}
