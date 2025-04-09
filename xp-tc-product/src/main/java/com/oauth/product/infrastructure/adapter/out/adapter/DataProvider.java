package com.oauth.product.infrastructure.adapter.out.adapter;

import com.oauth.product.application.dto.Products;
import com.oauth.product.application.port.UserDataProvider;
import com.oauth.product.domain.entities.dto.Users;
import com.oauth.product.infrastructure.adapter.out.entity.Product;
import com.oauth.product.infrastructure.adapter.out.repository.ProductRepository;
import com.oauth.product.infrastructure.mapper.ProductMapper;
import com.oauth.product.infrastructure.mapper.UserMapper;
import com.oauth.product.infrastructure.adapter.out.repository.UserRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataProvider implements UserDataProvider {

  private final UserRepository userRepository;
  private final ProductRepository productRepository;


  @Override

  public Users findUserByUserName(String u) {
    return userRepository.findUserByUsername(u)
        .map(UserMapper.INSTANCE::mapUser)
        .orElseThrow(()->  new UsernameNotFoundException("Error during authentication"));
  }

  @Override
  public List<Products> findAllProducts() {
    List<Product> products = productRepository.findAll();
    return ProductMapper.INSTANCE.productEntityToProductsDto(products);
  }
}