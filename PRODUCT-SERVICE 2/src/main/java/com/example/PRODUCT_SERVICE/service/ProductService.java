package com.example.PRODUCT_SERVICE.service;

import com.example.PRODUCT_SERVICE.dto.ProductDto;
import com.example.PRODUCT_SERVICE.entity.Product;
import com.example.PRODUCT_SERVICE.factories.ProductDtoFactory;
import com.example.PRODUCT_SERVICE.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

        public Product createProduct(Product product) {
            return productRepository.save(product);
        }

        public List<Product> findAll() {
            return productRepository.findAll();
        }

        public List<Product> findProductByCategory(String category) {
            return productRepository.findProductsByCategory(category);
        }
}
