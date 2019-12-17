package com.ibnshayed.www.controller;

import com.ibnshayed.www.service.ProductService;
import com.ibnshayed.www.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/prov1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public Mono<Product> createProduct(Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/product/{id}")
    public Mono<Product> getAProduct(@PathVariable String id){
        return productService.getAProduct(id);
    }

    @GetMapping("/products")
    public Flux<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Product> deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }
}
