package com.arturola.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product") //to mark product as a mongodb document (NoSql collection-document thing)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Product {
    @Id // To identify this is a unique identifier
    private String  id;
    private String name;
    private String description;
    private BigDecimal price;
}
