package com.interpobe.balicak.api;


import com.interpobe.balicak.dto.ProductDto;
import com.interpobe.balicak.mapper.ProductMapper;
import com.interpobe.balicak.service.ProductService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }


    @GetMapping()
    public List<ProductDto> all() {

        var allProduct = productService.all();
        return productMapper.toProductDtos(allProduct);
    }

    @GetMapping("/expirationDate")
    public List<ProductDto> expiredProducts(@RequestParam("expirationDate")
                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date expirationDate) {

        var expiredProducts = productService.expiredProducts(expirationDate);
        return productMapper.toProductDtos(expiredProducts);
    }


    @GetMapping("/noExpirationDate")
    public List<ProductDto> withNoExpirationDateProducts(@RequestParam("noExpirationDate")
                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date noExpirationDate) {

        var withNoExpirationDateProducts = productService.withNoExpirationDateProducts(noExpirationDate);
        return productMapper.toProductDtos(withNoExpirationDateProducts);
    }


    @GetMapping("/{id}")
    public ProductDto one(@PathVariable Long id) {

        var one = productService.getOne(id);
        return productMapper.toProductDto(one);

    }

    @PostMapping("")
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {

        var created = productService.create(productMapper.toProduct(dto));
        return new ResponseEntity<>(productMapper.toProductDto(created), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ProductDto update(@RequestBody ProductDto dto, @PathVariable Long id) {

        var create = productService.update(id, productMapper.toProduct(dto));
        return productMapper.toProductDto(create);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDto> delete(@PathVariable Long id) {

        productService.deleteById(id);
        return ResponseEntity.noContent().build();

    }



}
