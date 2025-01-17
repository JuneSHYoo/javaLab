package com.test.hyungSuh;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Product {
    // 상품 코드
    private Long code;
    private String name;
    private int price;
    private Type type;
    private int stock;

    public void updateStock(int stock) {
        this.stock = stock;
    }
}

enum Type {
    FOOD,
    DRINK;
}