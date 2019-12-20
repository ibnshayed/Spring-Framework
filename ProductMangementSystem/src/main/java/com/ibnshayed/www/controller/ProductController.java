package com.ibnshayed.www.controller;

import com.ibnshayed.www.model.Product;
import com.ibnshayed.www.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public Mono<Product> saveProduct(Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/products")
    public Flux<Product> getAllProduct(){
        return productService.readAllProduct();
    }

    @GetMapping("/product/{productId}")
    public Mono<Product> getAProduct(@PathVariable String productId){
        return productService.readOneProduct(productId);
    }

    @DeleteMapping("/product/{productId}")
    public Mono<Product> deleteProduct(@PathVariable String productId){
        return productService.deleteProduct(productId);
    }

}
