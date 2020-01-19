package com.ibnshayed.www.controller;

import com.ibnshayed.www.model.Product;
import com.ibnshayed.www.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/")
    Mono<Product> createProduct(@RequestBody Product product) {
            return this.productService.save(product);
    }

    @GetMapping("/products")
    Flux<Product> productList() {
        return this.productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Mono<Product> getProductById(@PathVariable(value = "id") String productId) {
            return this.productService.findById(productId);
    }

    @PutMapping("/product/{productId}")
    public Mono<Product> UpdateProductById(@PathVariable String productId, @RequestBody Product product) {

            return this.productService.update(product);
    }


    @DeleteMapping("/product/{productId}")
    public Mono<Product> deleteProductById(@PathVariable String productId) {
        return this.productService.delete(productId);
    }

    @PutMapping("/sellproduct/{productId}")
    public Mono<Product> sellProductById(@PathVariable String productId) {
        return this.productService.sellProduct(productId);
    }

    @PutMapping("/sellproduct/{productId}/{quantity}")
    public Mono<Product> sellProductById(@PathVariable String productId,@PathVariable int quantity) {
        return this.productService.addProductQuantity(productId, quantity);

    }


}
