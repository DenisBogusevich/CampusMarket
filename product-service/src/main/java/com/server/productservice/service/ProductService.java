package com.server.productservice.service;

import com.server.productservice.dto.product.CreateProductDtoRequest;
import com.server.productservice.dto.product.ProductDtoResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    ProductDtoResponse save(CreateProductDtoRequest product);

    List<ProductDtoResponse> findAll();

    ProductDtoResponse findById(Long id);

    ProductDtoResponse update(Long id, CreateProductDtoRequest bookDto);

    ProductDtoResponse changeStock(Long id, Long amount);

    ProductDtoResponse updatePromotionalPrice(Long id, Double newPrice);

    void deleteById(Long id);



}
