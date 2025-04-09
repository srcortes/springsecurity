package com.products.infrastructure.repositories;



import com.products.infrastructure.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductoEntity, Integer> {
}