package com.ibnshayed.www.controller;

import com.ibnshayed.www.domain.Product;
import com.ibnshayed.www.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductController {


    private final ProductRepository productRepository;


    @GetMapping("/products")
    public Publisher<Product> getAll(){
        return productRepository.findAll();
    }


}
