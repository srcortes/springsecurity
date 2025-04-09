package com.oauth.product.infrastructure.adapter.in;

import com.oauth.product.application.dto.Products;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface Operation {
  @GetMapping("/products")
  ResponseEntity<List<Products>> getProducts();
}
