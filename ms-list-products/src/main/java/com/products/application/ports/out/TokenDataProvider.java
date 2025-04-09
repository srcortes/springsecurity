package com.products.application.ports.out;



import com.products.infrastructure.entities.Token;
import java.util.Optional;

public interface TokenDataProvider {
  Optional<Token> getToken(String identifier);

  void saveToken(Token token);
}
