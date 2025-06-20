package com.example.PRODUCT_SERVICE.factories;

import com.example.PRODUCT_SERVICE.dto.ProductDto;
import com.example.PRODUCT_SERVICE.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoFactory {
    public ProductDto createProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setArticleNumber(product.getArticleNumber());
        productDto.setCategory(product.getCategory());
        return productDto;
    }

    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setArticleNumber(productDto.getArticleNumber());
        product.setCategory(productDto.getCategory());
        return product;
    }
}
