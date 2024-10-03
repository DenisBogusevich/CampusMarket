package com.server.productservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String photoName;
    @Column(nullable = false)
    private Double purchasePrice;
    @Column(nullable = false)
    private Double sellingPrice;
    @Column(nullable = true)
    private Double promotionalPrice;
    @Column(nullable = false)
    private Long stock;
}
