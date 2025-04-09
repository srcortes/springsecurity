package com.oauth.product.domain.entities.service;

import com.oauth.product.application.usecases.UserUseCase;
import com.oauth.product.infrastructure.adapter.out.adapter.DataProvider;
import com.oauth.product.application.dto.Products;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserUseCaseImp implements UserUseCase {

  private final DataProvider dataProvider;

  @Override
  public List<Products> getProducts() {
    return dataProvider.findAllProducts();
  }
}
