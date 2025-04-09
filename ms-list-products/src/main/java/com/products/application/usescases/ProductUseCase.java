package com.products.application.usescases;

import com.products.application.ports.in.ProductInPort;
import com.products.application.ports.out.ProductOutPort;
import com.products.domain.aggregates.ProductAggregate;
import com.products.domain.factories.Factory;
import com.products.domain.factories.Producto;
import com.products.dto.ProductDto;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ProductUseCase implements ProductInPort {

  private final ProductOutPort productOutPort;


  @Override
  public void saveProduct(ProductDto product) {
    Factory factory = new Producto();
    ProductAggregate productAggregate
            = factory.factoryPointPproduct(product.getName(), product.getPrice(), null);


    productOutPort.saveProduct(productAggregate);
  }




}
