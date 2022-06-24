package com.interpobe.balicak.service;
import com.interpobe.balicak.entity.ProductReview;
import com.interpobe.balicak.repository.ProductReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductReviewService {

    private final ProductReviewRepository productReviewRepository;

    public ProductReviewService(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }


    public List<ProductReview> findProductReviewByProductIdAndCommentDateBetween(Long productId, Date startDate, Date endDate)
    {
        return  productReviewRepository.findProductReviewByProductIdAndCommentDateBetween(productId,startDate,endDate);
    }



    public List<ProductReview> findProductReviewByUserIdAndCommentDateBetween(Long userId, Date startDate, Date endDate)
    {
        return  productReviewRepository.findProductReviewByUserIdAndCommentDateBetween(userId,startDate,endDate);
    }


    public  List<ProductReview> productReviews(Long productId)
    {
        return productReviewRepository.findByProductId(productId);
    }

    public  List<ProductReview> userReviews(Long userId)
    {
        return productReviewRepository.findByUserId(userId);
    }





}
