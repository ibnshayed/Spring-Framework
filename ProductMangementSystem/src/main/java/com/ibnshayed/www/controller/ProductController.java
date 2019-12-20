package com.ibnshayed.www.controller;

import com.ibnshayed.www.model.Product;
import com.ibnshayed.www.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @PostMapping("/product")
    Mono<ResponseEntity<Product>> createProduct(@RequestBody Product product) {
        return this.productRepository.save(product)
                .map(saveProduct -> ResponseEntity.ok(saveProduct));
    }

    @GetMapping("/products")
    Flux<Product> productList() {
        return this.productRepository.findAll().switchIfEmpty(Flux.empty());
    }

    @GetMapping("/product/{id}")
    public Mono<ResponseEntity<Product>> getProductById(@PathVariable(value = "id") String productId) {
        return this.productRepository.findById(productId)
                .map(savedProduct -> ResponseEntity.ok(savedProduct))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/product/{productId}")
    public Mono<ResponseEntity<Product>> getUserById(@PathVariable String productId, @RequestBody Product product){
        return this.productRepository.findById(productId)
                .flatMap(dbProduct -> {
                    dbProduct.setProductId(product.getProductId());
                    dbProduct.setProductName(product.getProductName());
                    dbProduct.setProductQuantity(product.getProductQuantity());
                    return this.productRepository.save(dbProduct);
                })
                .map(updatedProduct -> ResponseEntity.ok(updatedProduct))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }


    @DeleteMapping("/product/{productId}")
    public Mono<ResponseEntity<Void>> deleteProductById(@PathVariable String productId){
        return productRepository.findById(productId)
                .flatMap(existingProduct ->
                        productRepository.delete(existingProduct)
                                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
