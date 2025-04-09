package com.products.controller.interfaces;



import com.products.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController()
public interface Operation {

  @PostMapping("/createProduct")
  ResponseEntity<Void> createProduct(@RequestBody ProductDto products);
}
