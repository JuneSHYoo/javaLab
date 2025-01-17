package com.test.hyungSuh;

import java.util.*;
import java.util.stream.Collectors;

public class ConvenienceRepositoryImpl implements ConvenienceRepository {

    // 싱글톤 인스턴스 변수
    private static ConvenienceRepository convenienceRepository;

    // 상품 목록
    private static List<Product> products;
    // 상품 code 중복 확인
    private static Set<Long> productSet;

    private ConvenienceRepositoryImpl() {
        products = new ArrayList<>();
        productSet = new HashSet<>();
    }

    public static ConvenienceRepository getInstance() {
        if (convenienceRepository == null) {
            convenienceRepository = new ConvenienceRepositoryImpl();
        }

        return convenienceRepository;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
        productSet.add(product.getCode());
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findByCode(Long code) {
        return products.stream()
                .filter(product -> product.getCode().equals(code))
                .findFirst();
    }

    @Override
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.trim().toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByType(Type type) {
        return products.stream()
                .filter(product -> product.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByCode(Long code) {
        products.removeIf(product -> product.getCode().equals(code));
        productSet.removeIf(productCode -> productCode.equals(code));
    }

    @Override
    public void deleteAll() {
        products.clear();
        productSet.clear();
    }

    @Override
    public boolean existsByCode(Long code) {
        return productSet.contains(code);
    }
}
