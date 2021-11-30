package com.example.springbootquiz.data;

import com.example.springbootquiz.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {

}
