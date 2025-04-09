package com.products.controller;

import com.products.application.ports.in.ProductInPort;
import com.products.controller.interfaces.Operation;
import com.products.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class CommandController implements Operation {
    private final ProductInPort productPort;

    @Override
    public ResponseEntity<Void> createProduct(ProductDto product) {
        productPort.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
