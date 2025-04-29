package com.technobraintask.ecommerce_api.controller;

import com.technobraintask.ecommerce_api.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ProductService productService;

    @Test
    public void testCreateProduct() {

    }

    @Test
    public void testGetAllProducts() {

    }


    @Test
    public void testDeleteProduct() {

    }


  
}