package com.example.sample_spring_pr.repository;

import com.example.sample_spring_pr.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);

    Product findByNameAndPrice(String name, int price);

    Product findByName(String name);
}
