package com.interpobe.balicak.mapper;

import com.interpobe.balicak.dto.ProductReviewDto;
import com.interpobe.balicak.entity.ProductReview;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductReviewMapper {

    public ProductReviewDto toProductReviewDto(ProductReview productReview){
        return new ProductReviewDto(productReview.getComment(), productReview.getCommentDate());
    }

    public List<ProductReviewDto> toProductReviewDtos(List<ProductReview> list){
        return list.stream().map(this::toProductReviewDto).collect(Collectors.toList());
    }


}
