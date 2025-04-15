package com.gzu.service;

import com.gzu.entiry.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

//    提供商品信息
    Product getProductById(Long id);
}
