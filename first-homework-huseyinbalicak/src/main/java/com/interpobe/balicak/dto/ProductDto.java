package com.interpobe.balicak.dto;

import com.interpobe.balicak.entity.ProductReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    private String name;
    private double price;
    private Date expirationDate;
    private List<ProductReview> reviews;


}
