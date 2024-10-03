package com.server.productservice.dto.product;

public record CreateProductDtoRequest(
        String name,
        String photoName,
        Double purchasePrice,
        Double sellingPrice,
        Double promotionalPrice,
        Long stock)  {
}