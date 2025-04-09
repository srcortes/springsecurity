package com.products.application.ports.in;

import com.products.dto.ProductDto;

public interface ProductInPort {
 void saveProduct(ProductDto product);
}
