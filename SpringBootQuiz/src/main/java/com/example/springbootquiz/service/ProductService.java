package com.example.springbootquiz.service;

import com.example.springbootquiz.data.ProductRepo;
import com.example.springbootquiz.models.Product;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public List<Product> getListOfProducts() {
        List<Product> products = new ArrayList<>();
        productRepo.findAll().forEach(products::add);
        return products;
    }

    public void saveProduct(Product product) {
        productRepo.save(product);
    }
    public void updateProduct(Product product) {
        Product existingProductDetails = productRepo.findById(product.getId()).orElseThrow(
                () -> new ResourceNotFoundException("product Not Found"));
        if (product.getProductName() != null){
            existingProductDetails.setProductName(product.getProductName());
        }
        if (product.getProductCategory()!= null){
            existingProductDetails.setProductCategory(product.getProductCategory());
        }
        if (product.getProductDescription()!= null){
            existingProductDetails.setProductDescription(product.getProductDescription());
        }
        if (product.getProductCreationDate() != null){
            existingProductDetails.setProductCreationDate(product.getProductCreationDate());
        }
        productRepo.save(existingProductDetails);
    }
}
