package com.interpobe.balicak.repository;

import com.interpobe.balicak.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

    List<ProductReview> findByUserId(Long userId);
    List<ProductReview> findByProductId(Long productId);

    List<ProductReview> findProductReviewByUserIdAndCommentDateBetween(Long userId, Date startDate, Date endDate);
    List<ProductReview> findProductReviewByProductIdAndCommentDateBetween(Long productId, Date startDate, Date endDate);




}
