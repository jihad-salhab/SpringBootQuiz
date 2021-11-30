package com.example.springbootquiz.data;

import com.example.springbootquiz.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
}
