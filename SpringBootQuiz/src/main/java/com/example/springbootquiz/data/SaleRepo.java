package com.example.springbootquiz.data;

import com.example.springbootquiz.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepo extends JpaRepository<Sale,Long> {
}
