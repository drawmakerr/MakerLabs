package com.makerlabs.demo.service;

import com.makerlabs.demo.dto.ProductDto;
import com.makerlabs.demo.model.Category;
import com.makerlabs.demo.model.Product;
import com.makerlabs.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setName((productDto.getName()));
        product.setCategory(category);
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
    }

    public ProductDto getProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setName((product.getName()));
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setId(product.getId());
        return productDto;
    }

    public List<ProductDto> getAllProducts(){
        List<Product> allProducts = productRepo.findAll();

        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product: allProducts){
        productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    public void updateProduct(ProductDto productDto, Long productId) throws Exception {
       Optional<Product> optionalProduct = productRepo.findById(productId);
       // exception if product dont exist
        if (!optionalProduct.isPresent()) {
            throw new Exception("Product not here");
        }
        Product product = optionalProduct.get();
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setName((productDto.getName()));
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
    }

    public boolean deleteProduct(Long productId) {
        Optional<Product> productOptional = productRepo.findById(productId);
        if (productOptional.isPresent()) {
            productRepo.deleteById(productId);
            return true;
        } else {
            System.out.println("Product not exist with this ID: " + productId);
            return false;
        }
    }
}
