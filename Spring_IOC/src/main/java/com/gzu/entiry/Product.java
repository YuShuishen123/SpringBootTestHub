package com.gzu.entiry;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    Long productId;
    String productName;
    BigDecimal productPrice;
}
