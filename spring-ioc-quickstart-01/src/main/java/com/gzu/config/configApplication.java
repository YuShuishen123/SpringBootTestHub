package com.gzu.config;
import java.math.BigDecimal;
import java.util.HashMap;

import com.gzu.entiry.Cart;
import com.gzu.entiry.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Yu'S'hui'shen
 */ // config，包扫描路径配置类
@Configuration
@ComponentScan("com.gzu")
public class configApplication {
    @Bean
    @Scope("singleton")
    public Cart cart(){
        Cart initCart = new Cart();
        Product product1 = new Product();
        product1.setProductId(111L);
        product1.setProductName("iPadPro");
        product1.setProductPrice(new BigDecimal("8888"));
        Product product2 = new Product();
        product2.setProductId(222L);
        product2.setProductName("iPhone16");
        product2.setProductPrice(new BigDecimal("6666"));
        initCart.setCartId(1001);
        initCart.setUserID(1234);
        HashMap<Integer,Product> productsMap = new HashMap<>();
        productsMap.put(Math.toIntExact(product1.getProductId()),product1);
        productsMap.put(Math.toIntExact(product2.getProductId()),product2);
        initCart.setProductsMap(productsMap);
        return initCart;
    }
}
