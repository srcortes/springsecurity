package com.products.infrastructure.configuration;

import com.products.application.ports.out.ProductOutPort;
import com.products.application.usescases.ProductUseCase;
import com.products.domain.factories.Producto;
import org.springframework.context.annotation.Bean;

public class SpringConfiguration {

    @Bean
    public ProductUseCase productUseCase(ProductOutPort productOutPort) {
        return new ProductUseCase(productOutPort);
    }

    @Bean
    public Producto producto() {
        return new Producto();
    }
}
