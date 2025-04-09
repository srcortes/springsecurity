package com.products.domain.factories;

import com.products.domain.aggregates.ProductAggregate;

public abstract class Factory {

    public ProductAggregate factoryPointPproduct( String name, double price, String currency) {
        ProductAggregate product = createProduct(name, price, currency);
        return product;
    }

    abstract ProductAggregate createProduct(String name, double price, String currency);
}
