package com.ibnshayed.www.reactive;

import com.ibnshayed.www.domain.Product;
import com.ibnshayed.www.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Component
public class ToDoHandler {

    private ProductRepository repository;

    public ToDoHandler(ProductRepository repository){
        this.repository = repository;
    }

    public Mono<ServerResponse> getProduct(ServerRequest request) {
        return findById(request.pathVariable("id"));
    }

    public Mono<ServerResponse> getProducts(ServerRequest request) {
        Flux<Product> toDos = this.repository.findAll();
        return ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .body(toDos, Product.class);
    }

    public Mono<ServerResponse> newProduct(ServerRequest request) {
        Mono<Product> toDo = request.bodyToMono(Product.class);

        return ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .body(fromPublisher(toDo.flatMap(this::save), Product.class));
    }

    private Mono<ServerResponse> findById(String id){
        Mono<Product> toDo = this.repository.findById(id);

        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return toDo
                .flatMap(t -> ServerResponse
                        .ok()
                        .contentType(APPLICATION_JSON)
                        .body(fromObject(t)))
                .switchIfEmpty(notFound);
    }


    private Mono<Product> save(Product product) {
        return Mono.fromSupplier(
                () -> {
                    repository
                            .save(product)
                            .subscribe();
                    return product;
                });
    }
}