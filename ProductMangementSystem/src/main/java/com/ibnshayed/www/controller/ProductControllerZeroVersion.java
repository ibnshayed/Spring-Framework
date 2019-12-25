package com.ibnshayed.www.controller;
import com.ibnshayed.www.exception.ResourceAlreadyExistsException;
import com.ibnshayed.www.model.Product;
import com.ibnshayed.www.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/zero")
@RequiredArgsConstructor
public class ProductControllerZeroVersion {

    private final ProductRepository productRepository;

    @PostMapping("/product")
    Mono<ResponseEntity<String>> createProduct(@RequestBody Product product) {
        Mono<Boolean> monoPresent = productRepository.findById(product.getProductId()).hasElement();
        return productRepository.findById(product.getProductId())
                .flatMap(existingProduct ->
                        Mono.error(
                                new ResourceAlreadyExistsException("User already exists with productId ["
                                        + existingProduct.getProductId() + "]")))
                .switchIfEmpty(Mono.defer(() -> this.productRepository.save(product)))
                .map(saveProduct -> ResponseEntity.ok()
                        .body("Product Id is successfully created."));
/*        return this.productRepository.save(product)
                .map(saveProduct -> ResponseEntity.ok()
                        .body("Product Id' " + saveProduct.getProductId() + " is successfully created."));*/
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
    public Mono<ResponseEntity<Product>> UpdateProductById(@PathVariable String productId, @RequestBody Product product) {
        return this.productRepository.findById(productId)
                .flatMap(dbProduct -> {
                    dbProduct.setProductName(product.getProductName());
                    dbProduct.setProductQuantity(product.getProductQuantity());
                    return this.productRepository.save(dbProduct);
                })
                .map(updatedProduct -> ResponseEntity.ok(updatedProduct))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }


    @DeleteMapping("/product/{productId}")
    public Mono<ResponseEntity<String>> deleteProductById(@PathVariable String productId) {
        return this.productRepository.findById(productId)
                .flatMap(existingProduct ->
                        this.productRepository.delete(existingProduct)
                                .then(Mono.just(ResponseEntity.ok().body("Product Id' " + productId + " is deleted.")))
                )
                .defaultIfEmpty(ResponseEntity.badRequest().body("Product Id' " + productId + " doesn't exist."));
    }

    @PutMapping("/sellproduct/{productId}")
    public Mono<ResponseEntity<Product>> sellProductById(@PathVariable String productId) {
        Product product = this.productRepository.findById(productId).block();
        return this.productRepository.findById(productId)
                .filter(dbproduct -> dbproduct.getProductQuantity() > 0)
                .flatMap(dbProduct -> {
                    dbProduct.setProductQuantity(product.getProductQuantity() - 1);
                    return this.productRepository.save(dbProduct);
                })
                .map(updatedProduct -> ResponseEntity.ok(updatedProduct))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }


}