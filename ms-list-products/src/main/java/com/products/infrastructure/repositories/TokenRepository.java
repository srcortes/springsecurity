package com.products.infrastructure.repositories;


import com.products.infrastructure.entities.Token;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {
  Optional<Token> findTokenByIdentifier(String identifier);
}
