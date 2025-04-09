package com.oauth.product.infrastructure.mapper;

import com.oauth.product.infrastructure.adapter.out.entity.Product;
import com.oauth.product.application.dto.Products;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
  Products products(Product product);.

  List<Products> productEntityToProductsDto(List<Product> productList);


}
