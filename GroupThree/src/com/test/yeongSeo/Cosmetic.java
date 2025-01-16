package com.test.yeongSeo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Cosmetic {
    private String name;       // 제품명
    private String brand;      // 브랜드명
    private String category;   // 카테고리 (스킨케어, 메이크업 등)
    private double price;      // 가격
}
