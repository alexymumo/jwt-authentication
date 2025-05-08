package com.technobraintask.ecommerce_api.service;

import com.technobraintask.ecommerce_api.models.Product;
import com.technobraintask.ecommerce_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @CachePut(value = "PRODUCT_CACHE",key = "#result.id")
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }


    public Product updateProduct(Product updatedProduct) {
        return productRepository.save(updatedProduct);
    }
}
