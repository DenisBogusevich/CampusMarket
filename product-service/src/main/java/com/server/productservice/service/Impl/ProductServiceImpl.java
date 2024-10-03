package com.server.productservice.service.Impl;


import com.server.productservice.dto.product.CreateProductDtoRequest;
import com.server.productservice.dto.product.ProductDtoResponse;
import com.server.productservice.mapper.ProductMapper;
import com.server.productservice.model.Product;
import com.server.productservice.repository.ProductRepository;
import com.server.productservice.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public ProductDtoResponse save(CreateProductDtoRequest productDto) {
        System.out.println(productDto);
        Product product = productMapper.toProduct(productDto);
        System.out.println(product);
        return productMapper.toDto(productRepository.save(product));

    }

    @Override
    public List<ProductDtoResponse> findAll() {
        return productRepository.findAll().stream().map(productMapper::toDto).toList();
    }

    @Override
    public ProductDtoResponse findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() ->new EntityNotFoundException(
                    "can't find product with such id: %id".formatted(id)
        ));

    }


    @Override
    @Transactional
    public ProductDtoResponse update(Long id, CreateProductDtoRequest createProductDtoRequest) {

        ProductDtoResponse existingProductDtoResponse = findById(id);
        Product product = productMapper.toProduct(createProductDtoRequest);
        productMapper.updateProduct(createProductDtoRequest , product);
        return productMapper.toDto(productRepository.save(product));

    }

    @Override
    @Transactional
    public ProductDtoResponse changeStock(Long id, Long amount) {

        ProductDtoResponse existingProductDtoResponse = findById(id);
        Product product = productMapper.toProduct(existingProductDtoResponse);
        product.setStock(product.getStock() + amount);

        return productMapper.toDto(productRepository.save(product));

    }

    @Override
    @Transactional
    public ProductDtoResponse updatePromotionalPrice(Long id, Double newPrice) {

        ProductDtoResponse existingProductDtoResponse = findById(id);
        Product product = productMapper.toProduct(existingProductDtoResponse);
        product.setPromotionalPrice(product.getPromotionalPrice() + newPrice);
        return productMapper.toDto(productRepository.save(product));

    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
