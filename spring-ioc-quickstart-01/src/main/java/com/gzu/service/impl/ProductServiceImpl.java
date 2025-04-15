package com.gzu.service.impl;

import com.gzu.entiry.Product;
import com.gzu.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.Random;

@Component
@Repository
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long id) {
        Random random = new Random();
        Product product = new Product();
        product.setProductId(id);
        product.setProductName("笔记本");
        int randomInt = random.nextInt(10000);
        product.setProductPrice(BigDecimal.valueOf(randomInt));
        return product;
    }
}
