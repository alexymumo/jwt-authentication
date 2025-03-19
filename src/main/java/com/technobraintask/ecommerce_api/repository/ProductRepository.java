package com.technobraintask.ecommerce_api.repository;

import com.technobraintask.ecommerce_api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
