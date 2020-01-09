package com.ibnshayed.www.testController;

import com.ibnshayed.www.config.EmbeddedMongoDBConfigForProduct;
import com.ibnshayed.www.controller.ProductController;
import com.ibnshayed.www.model.Product;
import com.ibnshayed.www.repository.ProductRepository;
import com.ibnshayed.www.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ProductController.class)
@Import(ProductService.class)
public class TestProductController {

    @MockBean
    private ProductRepository repository;

    @Autowired
    private WebTestClient webClient;

    @Test
    public void testGetProductById() throws Exception
    {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("name1");
        product.setProductQuantity(12);

        Mockito
                .when(repository.findById("1"))
                .thenReturn(Mono.just(product));

        this.webClient.get()
                .uri("/v1/product/{id}", "1")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.productId").isEqualTo("1")
                .jsonPath("$.productName").isEqualTo("name1")
                .jsonPath("$.productQuantity").isEqualTo(12);

        Mockito.verify(repository, times(1)).findById("1");
    }
}
