package com.makerlabs.demo.repository;

import com.makerlabs.demo.model.Category;
import com.makerlabs.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
