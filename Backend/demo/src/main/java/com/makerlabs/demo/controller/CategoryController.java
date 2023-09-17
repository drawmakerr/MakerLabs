package com.makerlabs.demo.controller;

import com.makerlabs.demo.model.Category;
import com.makerlabs.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Success!";
    }
    @GetMapping("/list")
    public List<Category> listCategory(){
        List<Category> categories= categoryService.listCategory();
       return categories;
    }

    @PutMapping("/update/{categoryId}")
    public String updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category){
        categoryService.editCategory((long) categoryId, category);
        return "Updated!";
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer categoryId){
        boolean deleted = categoryService.deleteCategory(Long.valueOf(categoryId));
        if (deleted) {
            return ResponseEntity.ok("Category deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
















