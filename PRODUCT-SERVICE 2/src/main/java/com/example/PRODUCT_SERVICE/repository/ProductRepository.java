package com.example.PRODUCT_SERVICE.repository;

import com.example.PRODUCT_SERVICE.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
