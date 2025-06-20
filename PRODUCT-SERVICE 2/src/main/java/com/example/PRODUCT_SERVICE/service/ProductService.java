package com.example.PRODUCT_SERVICE.service;

import com.example.PRODUCT_SERVICE.dto.ProductDto;
import com.example.PRODUCT_SERVICE.entity.Product;
import com.example.PRODUCT_SERVICE.factories.ProductDtoFactory;
import com.example.PRODUCT_SERVICE.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

        public List<Product> findProductByCategory(String category, String sort) {
            List<Product> listProduct;
            if(sort != null && !sort.isEmpty()) {
                if(sort.equals("asc")) {
                    listProduct = productRepository.findProductsByCategoryOrderByPriceAsc(category);
                } else if(sort.equals("desc")) {
                    listProduct = productRepository.findProductsByCategoryOrderByPriceDesc(category);
                }else{
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid sort parameter");
                }
            }else {
                listProduct = productRepository.findProductsByCategory(category);
            }
            return listProduct;

        }


}
