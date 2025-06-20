package com.example.PRODUCT_SERVICE.controller;

import com.example.PRODUCT_SERVICE.dto.ProductDto;
import com.example.PRODUCT_SERVICE.entity.Product;
import com.example.PRODUCT_SERVICE.factories.ProductDtoFactory;
import com.example.PRODUCT_SERVICE.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product")
public class ProductController {
    private final ProductDtoFactory productDtoFactory;
    private final ProductService productService;

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        Product product = productDtoFactory.createProduct(productDto);
        productService.createProduct(product);
        return productDto;
    }


    //todo, вынести в dto factory
    @GetMapping
    public List<ProductDto> findAllProducts() {
        return productService.findAll()
                .stream()
                .map(product -> productDtoFactory.createProductDto(product))
                .toList();

    }

    @GetMapping("/category")
    public List<ProductDto> findProductsByCategory(@RequestParam String category) {
        return productService.findProductByCategory(category)
                .stream()
                .map(product -> productDtoFactory.createProductDto(product))
                .toList();

    }
}
