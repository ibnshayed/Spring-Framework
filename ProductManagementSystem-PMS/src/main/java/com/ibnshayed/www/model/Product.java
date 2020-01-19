package com.ibnshayed.www.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"productId","productName"})
public class Product {
    @Id
    private String productId;
    private String productName;
    private int productQuantity;

}
