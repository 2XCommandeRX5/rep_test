package com.example.sample_spring_pr;

import com.example.sample_spring_pr.entity.Cart;
import com.example.sample_spring_pr.entity.Product;
import com.example.sample_spring_pr.entity.ProductItem;
import com.example.sample_spring_pr.model.AddProductsRequest;
import com.example.sample_spring_pr.model.StatusResponse;
import com.example.sample_spring_pr.repository.CartRepository;
import com.example.sample_spring_pr.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public HomeService(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }



    public String getIndexPage (String name){
        return String.format("Hello, %s", name);
    }

    public StatusResponse addProducts(AddProductsRequest request) {
        List<Cart> cartItems = cartRepository.findAllByUserId(request.getUserId());
        for (ProductItem item : request.getProducts()) {
            Cart currentCart = null;
             for (Cart cart : cartItems) {
                 if (cart.getProduct().getName().equalsIgnoreCase(item.getName())){
                     currentCart = cart;
                     break;
                 }
             }
            if(currentCart == null) {
                currentCart = new Cart();
                currentCart.setUserId(request.getUserId());
                currentCart.setProduct(productRepository.findByName(item.getName()));
            }
            currentCart.setAmount(currentCart.getAmount()+item.getCount());
            cartRepository.save(currentCart);
        }

        return new StatusResponse();
    }
}
