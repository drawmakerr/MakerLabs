package com.makerlabs.demo.service;

import com.makerlabs.demo.dto.ProductDto;
import com.makerlabs.demo.dto.cart.AddToCartDto;
import com.makerlabs.demo.model.Cart;
import com.makerlabs.demo.model.Category;
import com.makerlabs.demo.model.Product;
import com.makerlabs.demo.repository.CartRepo;
import com.makerlabs.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;
    }





