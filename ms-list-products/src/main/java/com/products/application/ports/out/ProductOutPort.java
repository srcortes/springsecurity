package com.products.application.ports.out;

import com.products.domain.aggregates.ProductAggregate;
import com.products.domain.factories.Producto;


public interface ProductOutPort {
    void saveProduct(ProductAggregate product);
}
