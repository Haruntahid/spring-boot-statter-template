package com.example.practice.service;

import com.example.practice.model.dto.ProductDto;
import com.example.practice.model.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    void createProduct(Product product);

    void updateProduct(Long id, ProductDto dto);

    void deleteProduct(Long id);

    Product getProduct(Long id);

}
