package com.interpobe.balicak.api;

import com.interpobe.balicak.dto.ProductReviewDto;
import com.interpobe.balicak.mapper.ProductReviewMapper;
import com.interpobe.balicak.service.ProductReviewService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class ProductReviewController {

    private final ProductReviewService productReviewService;
    private final ProductReviewMapper productReviewMapper;

    public ProductReviewController(ProductReviewService productReviewService, ProductReviewMapper productReviewMapper) {
        this.productReviewService = productReviewService;
        this.productReviewMapper = productReviewMapper;
    }

    @GetMapping("/product/{productId}/startDate/endDate")
    List<ProductReviewDto> findProductReviewByProductIdAndCommentDateBetween(@PathVariable Long productId,@RequestParam("startDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,@RequestParam("endDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate)
    {

        var productReviewsByProductIdAndCommentDateBetween = productReviewService.findProductReviewByProductIdAndCommentDateBetween(productId,startDate,endDate);
        return productReviewMapper.toProductReviewDtos(productReviewsByProductIdAndCommentDateBetween);

    }

    @GetMapping("/user/{userId}/startDate/endDate")
    List<ProductReviewDto> findProductReviewByUserIdAndCommentDateBetween(@PathVariable Long userId,@RequestParam("startDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,@RequestParam("endDate")
                                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate)
    {

        var productReviewsByUserIdAndCommentDateBetween = productReviewService.findProductReviewByUserIdAndCommentDateBetween(userId,startDate,endDate);
        return productReviewMapper.toProductReviewDtos(productReviewsByUserIdAndCommentDateBetween);

    }

    @GetMapping("/products/{productId}")
    public List<ProductReviewDto> productReviews(@PathVariable  Long productId)
    {
        var productReviews=productReviewService.productReviews(productId);
        return productReviewMapper.toProductReviewDtos(productReviews);
    }

    @GetMapping("/users/{userId}")
    public List<ProductReviewDto> userReviews(@PathVariable  Long userId)
    {
        var userReviews=productReviewService.userReviews(userId);
        return productReviewMapper.toProductReviewDtos(userReviews);
    }


}
