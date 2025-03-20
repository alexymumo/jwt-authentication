package com.technobraintask.ecommerce_api.controller;

import com.technobraintask.ecommerce_api.models.Product;
import com.technobraintask.ecommerce_api.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "create a product")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "created a product", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))}), @ApiResponse(responseCode = "500", description = "internal server error", content = @Content)}
    )
    @PostMapping("/create")
    public ResponseEntity<Product> registerProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }


    @Operation(summary = "get all products")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "200",description = "get all products",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Product.class))}),@ApiResponse(responseCode = "404",description = "Not found",content = @Content)}
    )
    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }


    @Operation(summary = "delete product by id")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "200",description = "delete product by id",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Product.class))}),@ApiResponse(responseCode = "404",description = "Not found",content = @Content)}
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        Optional<Product> exists = this.productService.getProductById(id);
        if (exists.isPresent()) {
            productService.deleteProductById(id);
        }
        return ResponseEntity.ok("Deleted Product Successfully");
    }


    @Operation(summary = "update product by id")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "200",description = "update product",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Product.class))}),@ApiResponse(responseCode = "404",description = "Not found",content = @Content)}
    )
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") Long id,@RequestBody Product product) {
        Optional<Product> exists = this.productService.getProductById(id);
        if (exists.isPresent()) {
            productService.updateProduct(product);
        }
        return ResponseEntity.ok(product);

    }
}
