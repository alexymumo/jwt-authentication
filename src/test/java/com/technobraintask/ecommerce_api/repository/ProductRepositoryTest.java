package com.technobraintask.ecommerce_api.repository;

import com.technobraintask.ecommerce_api.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void test_empty_repository() {
        Iterable<Product> products = productRepository.findAll();
        assertThat(products).isEmpty();
    }

    @Test
    public void testCreateProduct() {
        Product product = productRepository.save(new Product(1L,"test product","test category",23,"test brand",23));
        productRepository.save(product);
        assertThat(product).hasFieldOrPropertyWithValue("productName","test product");
        assertThat(product).hasFieldOrPropertyWithValue("category","test category");
        assertThat(product).hasFieldOrPropertyWithValue("price",23);
    }

    public void test_get_all_products() {

    }


    @AfterEach
    void tearDown() {
      //  productRepository.deleteAll();

    }

}