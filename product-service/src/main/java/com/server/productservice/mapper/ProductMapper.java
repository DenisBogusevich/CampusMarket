package com.server.productservice.mapper;


import com.server.productservice.dto.product.CreateProductDtoRequest;
import com.server.productservice.dto.product.ProductDtoResponse;
import com.server.productservice.model.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        implementationPackage = "<PACKAGE_NAME>.impl")
public interface ProductMapper {

    ProductDtoResponse toDto(Product product);


    Product toProduct(CreateProductDtoRequest productDto);

    Product toProduct(ProductDtoResponse productDto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProduct(CreateProductDtoRequest updatedRequestDto, @MappingTarget Product product);

    CreateProductDtoRequest toCreateProductDtoRequest( ProductDtoResponse productDtoResponse);

}
