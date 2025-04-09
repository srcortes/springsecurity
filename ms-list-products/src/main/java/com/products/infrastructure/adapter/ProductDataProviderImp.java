package com.products.infrastructure.adapter;

import com.products.application.ports.out.ProductOutPort;
import com.products.domain.aggregates.ProductAggregate;
import com.products.infrastructure.entities.Currencies;
import com.products.infrastructure.entities.ProductoEntity;
import com.products.infrastructure.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductDataProviderImp implements ProductOutPort {
    private ProductRepository productRepository;


    @Override
    public void saveProduct(ProductAggregate productAggregate) {
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setId(Integer.valueOf(productAggregate.getId()));
        productoEntity.setName(productAggregate.getName());
        productoEntity.setCurrency(Currencies.valueOf(productAggregate.getCurrency().name()));
        productoEntity.setPrice(productAggregate.getPrice());
        productRepository.save(productoEntity);
    }
}
