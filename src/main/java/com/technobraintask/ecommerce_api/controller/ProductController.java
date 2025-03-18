package com.technobraintask.ecommerce_api.controller;

import com.technobraintask.ecommerce_api.models.Product;
import com.technobraintask.ecommerce_api.repository.ProductRepository;
import com.technobraintask.ecommerce_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Product> registerProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }


    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
}
