package com.makerlabs.demo.service;

import com.makerlabs.demo.model.Category;
import com.makerlabs.demo.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    public void createCategory(Category category){
        categoryRepo.save(category);
    }

    public List<Category> listCategory(){
       return categoryRepo.findAll();
    }

    public void editCategory(Long categoryId, Category updateCategory) {
        Category category = categoryRepo.getById(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        category.setImageUrl(updateCategory.getImageUrl());
        categoryRepo.save(category);
    }

    public boolean deleteCategory(Long categoryId) {
            Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
            if (categoryOptional.isPresent()) {
                categoryRepo.deleteById(categoryId);
                return true;
            } else {
                System.out.println("Category not exist with this ID: " + categoryId);
                return false;
            }
        }
    }
