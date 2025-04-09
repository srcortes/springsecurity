package com.oauth.product.application.usecases;

import com.oauth.product.application.dto.Products;
import java.util.List;

public interface UserUseCase {
  List<Products> getProducts();
}
