package com.interpobe.balicak.mapper;

import com.interpobe.balicak.dto.ProductDto;
import com.interpobe.balicak.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {


    public ProductDto toProductDto(Product product){
        return new ProductDto(product.getName(), product.getPrice(), product.getExpirationDate(),product.getReviews());
    }

    public List<ProductDto> toProductDtos(List<Product> list){
        return list.stream().map(this::toProductDto).collect(Collectors.toList());
    }

    public Product toProduct(ProductDto productDto){
        return new Product(productDto.getName(), productDto.getPrice(), productDto.getExpirationDate(),productDto.getReviews());
    }

    public List<Product> toProducts(List<ProductDto> list){
        return list.stream().map(this::toProduct).collect(Collectors.toList());
    }



}
