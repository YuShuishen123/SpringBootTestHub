package com.gzu.service.impl;

import com.gzu.entiry.Cart;
import com.gzu.entiry.Product;
import com.gzu.service.CartService;
import com.gzu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartServiceImpl implements CartService {
//    注入一个购物车实例
    Cart cart;
    ProductService productService;

    @Autowired
    public CartServiceImpl(Cart cart,ProductService productService) {
        this.cart = cart;
        this.productService = productService;
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public void addProduct(Long productId) {
        Product product = productService.getProductById(productId);
        cart.getProductsMap().put(Math.toIntExact(productId),productService.getProductById(productId));
    }

    @Override
    public void deleteProduct(Long productId) {
        cart.getProductsMap().remove(productId.intValue());
    }
}
