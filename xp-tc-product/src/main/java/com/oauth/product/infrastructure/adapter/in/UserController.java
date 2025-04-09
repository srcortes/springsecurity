package com.oauth.product.infrastructure.adapter.in;

import com.oauth.product.application.usecases.UserUseCase;
import com.oauth.product.application.dto.Products;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController{

  private final UserUseCase userUseCase;

  @GetMapping("/products")
  public ResponseEntity<List<Products>> getProducts(){
    return ResponseEntity.ok(userUseCase.getProducts());
  }

}
