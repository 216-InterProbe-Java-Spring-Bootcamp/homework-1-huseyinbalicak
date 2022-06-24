package com.interpobe.balicak.dto;

import com.interpobe.balicak.entity.ProductReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private List<ProductReview> reviews;

}
