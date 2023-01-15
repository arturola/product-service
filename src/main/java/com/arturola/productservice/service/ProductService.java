package com.arturola.productservice.service;

import com.arturola.productservice.dto.ProductRequest;
import com.arturola.productservice.dto.ProductResponse;
import lombok.*;
import com.arturola.productservice.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.arturola.productservice.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j //--> for the LOGGER
public class ProductService {
    private Product product;
    private ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build(); //--> esto creará el Object de tipo Product

        productRepository.save(product);
        log.info("Product {} is saved ", product.getId());
    }
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }


}
