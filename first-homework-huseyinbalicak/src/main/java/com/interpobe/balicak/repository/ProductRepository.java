package com.interpobe.balicak.repository;

import com.interpobe.balicak.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("select p from Product p where p.expirationDate > ?1")
    List<Product> getExpirationDateAfter(Date expirationDate);

    List<Product> findByExpirationDateBefore(Date expirationDate);


}
