package com.makerlabs.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProductDto {
    // for create it could be optional
    // for update we need the id
    private Long id;
    private String name;
    private String imageUrl;
    private double price;
    private String description;
    private Long categoryId;
}
