package com.ibnshayed.www;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;

    public Mono<Product> createProduct(Product product){
        return productRepo.save(product);
    }

    public Mono<Product> getAProduct(String productId){
        return productRepo.findById(productId).switchIfEmpty(Mono.empty());
    }

    public Flux<Product> getAllProduct(){
        return productRepo.findAll();
    }

    public Mono<Product> deleteProduct(String id){
        return productRepo.findById(id)
                .flatMap(product -> productRepo.delete(product).then(Mono.just(product)));
    }

}
