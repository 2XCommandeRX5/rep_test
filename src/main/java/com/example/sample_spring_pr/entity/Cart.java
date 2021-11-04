package com.example.sample_spring_pr.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Cart {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private Long userId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int amount;

}
