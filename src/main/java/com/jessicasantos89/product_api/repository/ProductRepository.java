package com.jessicasantos89.product_api.repository;

import com.jessicasantos89.product_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    public List<Product> findByName(String name);
}
