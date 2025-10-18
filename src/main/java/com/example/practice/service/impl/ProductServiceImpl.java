package com.example.practice.service.impl;

import com.example.practice.exception.NotFoundException;
import com.example.practice.model.dto.ProductDto;
import com.example.practice.model.entity.Product;
import com.example.practice.model.mapper.ProductMapper;
import com.example.practice.repository.ProductRepo;
import com.example.practice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepository;
    private final ProductMapper productMapper;


    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Long id, ProductDto dto) {
        Product exProduct = getProduct(id);
        productMapper.updateEntityFromDto(dto, exProduct);
        productRepository.save(exProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = getProduct(id);
        productRepository.delete(product);
    }

    @Override
    public Product getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new NotFoundException("Product not found with id " + id);
        }
        return product.get();
    }
}
