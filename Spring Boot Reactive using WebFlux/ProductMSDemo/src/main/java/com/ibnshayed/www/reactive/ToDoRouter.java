package com.ibnshayed.www.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ToDoRouter {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(ToDoHandler toDoHandler) {
        return route(GET("/product/{id}").and(accept(APPLICATION_JSON)), toDoHandler::getProduct)
                .andRoute(GET("/product").and(accept(APPLICATION_JSON)), toDoHandler::getProducts)
                .andRoute(POST("/product").and(accept(APPLICATION_JSON)), toDoHandler::newProduct);
    }
}