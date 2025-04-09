package com.oauth.product.application.port;



import com.oauth.product.domain.entities.dto.Users;
import com.oauth.product.application.dto.Products;
import java.util.List;

public interface UserDataProvider {
  Users findUserByUserName(String u);
  List<Products> findAllProducts();
}
