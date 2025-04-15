package com.gzu.entiry;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;

@Data
public class Cart {
    int cartId;
    int userID;
    HashMap<Integer,Product> productsMap;
}
