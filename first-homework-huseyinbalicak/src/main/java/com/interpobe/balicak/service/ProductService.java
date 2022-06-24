package com.interpobe.balicak.service;

import com.interpobe.balicak.entity.Product;
import com.interpobe.balicak.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {


    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> all() {
        return productRepository.findAll();
    }


    public Product getOne(Long id) {
        return productRepository.getOne(id);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


    public List<Product> expiredProducts(Date expirationDate)
    {

        return productRepository.getExpirationDateAfter(expirationDate);
    }

    public List<Product>  withNoExpirationDateProducts(Date expirationDate)
    {

        return productRepository.findByExpirationDateBefore(expirationDate);
    }





}
