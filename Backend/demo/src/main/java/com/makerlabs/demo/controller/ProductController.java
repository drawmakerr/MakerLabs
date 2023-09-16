package com.makerlabs.demo.controller;

import com.makerlabs.demo.dto.ProductDto;
import com.makerlabs.demo.model.Category;
import com.makerlabs.demo.repository.CategoryRepo;
import com.makerlabs.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepo categoryRepo;

    @PostMapping("/add")
    public String createProduct(@RequestBody ProductDto productDto){
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return "Category don´t exist!";
        }
        productService.createProduct(productDto, optionalCategory.get());
        return "Product has been added";
    }

    @GetMapping("/")
    public List<ProductDto> getProducts(){
        return productService.getAllProducts();
    }
}
