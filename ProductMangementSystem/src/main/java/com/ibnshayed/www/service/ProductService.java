package com.ibnshayed.www.service;

import com.ibnshayed.www.model.Product;
import com.ibnshayed.www.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;

    public Flux<Product> getProducts(){
        return productRepo.findAll().switchIfEmpty(Flux.empty());
    }
}
