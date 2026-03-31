package com.example.practice.controller;

import com.example.practice.constant.ApiConstants;
import com.example.practice.model.dto.ProductDto;
import com.example.practice.model.entity.Product;
import com.example.practice.model.mapper.ProductMapper;
import com.example.practice.response.ApiResponse;
import com.example.practice.response.ResponseWithData;
import com.example.practice.response.ServerResponse;
import com.example.practice.service.ProductService;
import com.example.practice.utils.commons.CrudController;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.API+ApiConstants.API_VERSION_V1)
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class ProductController implements CrudController<ProductDto> {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Override
    @PostMapping("/product")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody ProductDto dto) {
        productService.createProduct(productMapper.toEntity(dto));
        return ServerResponse.created("Product Created Successfully");
    }

    @Override
    @PatchMapping("/product/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id,@Valid @RequestBody ProductDto dto) {
        productService.updateProduct(id,dto);
        return ServerResponse.ok("Product Updated Successfully");
    }

    @Override
    @DeleteMapping("/product/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ServerResponse.ok("Product Deleted Successfully");
    }

    @Override
    @GetMapping("/product/{id}")
    public ResponseEntity<ResponseWithData> find(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        return ServerResponse.withData("Product fetch successfully",product);
    }

}
