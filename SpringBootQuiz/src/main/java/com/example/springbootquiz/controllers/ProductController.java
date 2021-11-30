package com.example.springbootquiz.controllers;

import com.example.springbootquiz.models.Product;
import com.example.springbootquiz.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    public ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping(path = "/api/v1/products")
    List<Product> getProducts()  {
        return productService.getListOfProducts();
    }
    @PostMapping(path = "api/v1/add_product")
    void addNewProduct(@RequestBody(required = true) Product product) {
        productService.saveProduct(product);
    }
    @PostMapping(path = "api/v1/update_product")
    void updateExistProduct(@RequestBody(required = true) Product product) {
        productService.updateProduct(product);
    }
}
