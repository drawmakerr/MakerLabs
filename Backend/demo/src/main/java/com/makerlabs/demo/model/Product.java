package com.makerlabs.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    Category category;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String imageUrl;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String description;


}
