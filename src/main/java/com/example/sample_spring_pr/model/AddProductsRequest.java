package com.example.sample_spring_pr.model;

import com.example.sample_spring_pr.entity.ProductItem;
import com.sun.istack.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class AddProductsRequest {
    @NotNull
    private Long userId;
    private List<ProductItem> products;
}

