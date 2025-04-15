package com.gzu.service;

import com.gzu.entiry.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
//    查询购物车
    Cart getCart();
//    添加商品
    void addProduct(Long productId);
//    删除商品
    void deleteProduct(Long productId);
}
