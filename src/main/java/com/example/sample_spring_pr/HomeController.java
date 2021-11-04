package com.example.sample_spring_pr;

import com.example.sample_spring_pr.entity.Cart;
import com.example.sample_spring_pr.entity.Product;
import com.example.sample_spring_pr.model.AddProductsRequest;
import com.example.sample_spring_pr.model.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/home")
    public String index(@RequestParam(name = "userName") String name) {
        return homeService.getIndexPage(name);
    }

    @PostMapping(value = "/sale", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public StatusResponse productSale(@RequestBody List<Product> products) {
        //INPUT: product [ name, price, quantity ]
        return new StatusResponse();
    }

    @PutMapping(value = "/cart", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public StatusResponse addProducts(@RequestBody AddProductsRequest request) {
     return homeService.addProducts(request);
    }
}
