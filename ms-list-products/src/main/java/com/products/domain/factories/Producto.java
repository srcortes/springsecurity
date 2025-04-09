package com.products.domain.factories;

import com.products.domain.aggregates.ProductAggregate;


public class Producto extends Factory {
    @Override
    ProductAggregate createProduct(String name, double price, String currency) {
        return ProductAggregate.createProduct(name, price, currency);
    }
}
