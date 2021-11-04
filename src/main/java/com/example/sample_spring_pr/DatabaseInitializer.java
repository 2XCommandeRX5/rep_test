package com.example.sample_spring_pr;

import com.example.sample_spring_pr.entity.Product;
import com.example.sample_spring_pr.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseInitializer {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    private void addSampleProducts() {
        Product tomato = new Product("tomato", 12);
        Product potato = new Product("potato", 15);
        Product orange = new Product("orange", 18);
        List<Product> products = new ArrayList<>();
        products.add(tomato);
        products.add(potato);
        products.add(orange);

        for (Product product : products) {
            if (!productRepository.existsByName(product.getName())) {
                productRepository.save(product);
            }
        }
    }
}
