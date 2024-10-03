package com.server.productservice.controller;

import com.server.productservice.dto.product.CreateProductDtoRequest;
import com.server.productservice.dto.product.ProductDtoResponse;
import com.server.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDtoResponse> getAll(){
        return productService.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDtoResponse createProduct(@RequestBody CreateProductDtoRequest productDtoRequest) {


        return productService.save(productDtoRequest);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDtoResponse updateProduct(@PathVariable Long id,
                         @RequestBody  CreateProductDtoRequest createProductDtoRequest) {
     return productService.update(id,createProductDtoRequest);
    }
    @PutMapping("/stock/{id}/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDtoResponse updateStock(@PathVariable Long id, @PathVariable Long amount) {
        return productService.changeStock(id,amount);
    }
    @PutMapping("/promotional/{id}/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDtoResponse updatePromotionalPrice(@PathVariable Long id, @PathVariable Double newPrice) {
        return productService.updatePromotionalPrice(id,newPrice);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Long id) { productService.deleteById(id);}



}

