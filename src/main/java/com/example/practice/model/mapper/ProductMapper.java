package com.example.practice.model.mapper;

import com.example.practice.model.dto.ProductDto;
import com.example.practice.model.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    // DTO → Entity
    public static Product toEntity(ProductDto dto) {
        if (dto == null) return null;

        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }

    // Entity → DTO
    public static ProductDto toDto(Product entity) {
        if (entity == null) return null;

        ProductDto dto = new ProductDto();
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    // ✅ Existing Entity Update from DTO
    public static void updateEntityFromDto(ProductDto dto, Product entity) {
        if (dto == null || entity == null) return;

        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
        if (dto.getPrice() != null) entity.setPrice(dto.getPrice());
    }
}
