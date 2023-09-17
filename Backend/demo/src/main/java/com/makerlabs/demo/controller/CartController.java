package com.makerlabs.demo.controller;

import com.makerlabs.demo.dto.cart.AddToCartDto;
import com.makerlabs.demo.model.Category;
import com.makerlabs.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    public ResponseEntity<String> addToCart(@RequestBody AddToCartDto addToCartDto){
        boolean added = cartService.addToCart(addToCartDto);
        if (added) {
            return ResponseEntity.ok("Product added!");
        } else {
            return ResponseEntity.badRequest().body("Can´t add the product...");
        }
    }

}
