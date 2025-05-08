package com.gzu.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest()
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // 添加此注解启用顺序控制,否则执行顺序随机
class CartControllerTest {
    @Autowired
    CartController cartController;
    @Test
    @Order(1)
    void getCartInfo() {
        System.out.println("查询购物车CartControllerTest.getCartInfo");
        System.out.println(cartController.getCartInfo());
        System.out.println("--------------------------------------------");

    }

    @Test
    @Order(2)
    void addProduct() {
        System.out.println("插入购物车CartControllerTest.addProduct");
        System.out.println(cartController.addProduct(123123L));
        System.out.println("--------------------------------------------");

    }

    @Test
    @Order(3)
    void delProduct() {
        System.out.println("删除购物车CartControllerTest.delProduct");
        System.out.println(cartController.delProduct(123123L));
        System.out.println("--------------------------------------------");

    }

/*    @Test
    void testAll(){
        System.out.println("查询购物车");
        System.out.println(cartController.getCartInfo());
        System.out.println("插入购物车");
        System.out.println(cartController.addProduct(123123L));
        System.out.println("删除购物车");
        System.out.println(cartController.delProduct(123123L));
        System.out.println("--------------------------------------------");
    }*/
}