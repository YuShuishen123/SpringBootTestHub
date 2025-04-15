package com.gzu.controller;


import com.gzu.entiry.Cart;
import com.gzu.service.CartService;
import com.gzu.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yu'S'hui'shen
 */
@RestController
public class CartController {

//    注入商品服务
    ProductService productService;
//    注入购物车服务
    CartService cartService;
//    使用构造器注入
    public CartController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }
    //    获取购物车
    @GetMapping("/cart/info")
    public Cart getCartInfo(){
        return cartService.getCart();
    }
    //    添加商品
    @PostMapping("/cart/addProducts")
    public Cart addProduct(@RequestParam("ProductID") Long productID){
        cartService.addProduct(productID);
        return cartService.getCart();
    }
    //    删除商品
    @PostMapping("/cart/delProducts")
    public Cart delProduct(@RequestParam("ProductID") Long productID){
        cartService.deleteProduct(productID);
        return cartService.getCart();
    }
}
