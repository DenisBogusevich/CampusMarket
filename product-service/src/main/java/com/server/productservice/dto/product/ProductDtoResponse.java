package com.server.productservice.dto.product;

public record ProductDtoResponse(

        Long id,
        String name,
        String photoName,
        Double purchasePrice,
        Double sellingPrice,
        Double promotionalPrice,
        Long stock


) {
}
