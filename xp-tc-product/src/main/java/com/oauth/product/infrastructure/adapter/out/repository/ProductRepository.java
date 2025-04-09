package com.oauth.product.infrastructure.adapter.out.repository;

import com.oauth.product.infrastructure.adapter.out.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
