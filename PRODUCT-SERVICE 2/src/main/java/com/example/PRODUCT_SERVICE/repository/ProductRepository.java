package com.example.PRODUCT_SERVICE.repository;

import com.example.PRODUCT_SERVICE.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findProductsByCategory(String category);
    List<Product> findProductsByCategoryOrderByPriceAsc(String category);
    List<Product> findProductsByCategoryOrderByPriceDesc(String category);

}
