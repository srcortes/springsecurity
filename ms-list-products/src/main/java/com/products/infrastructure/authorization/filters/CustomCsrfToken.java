package com.products.infrastructure.authorization.filters;



import com.products.application.ports.out.TokenDataProvider;
import com.products.infrastructure.entities.Token;
import java.util.Optional;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;

public class CustomCsrfToken implements CsrfTokenRepository {
  private TokenDataProvider tokenDataProvider;

  @Override
  public CsrfToken generateToken(HttpServletRequest request) {
    String uuid = UUID.randomUUID().toString();
    return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", uuid);
  }

  @Override
  public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
    String identifier = request.getHeader("X-IDENTIFIER");
    Optional<Token> existingToken =  tokenDataProvider.getToken(identifier);
    if(existingToken.isPresent()){
      Token tokeAggregate = existingToken.get();
      tokeAggregate.setToken(token.getToken());
    }else{
      Token tokeAggregate = new Token();
      tokeAggregate.setToken(token.getToken());
      tokeAggregate.setIdentifier(identifier);
      tokenDataProvider.saveToken(tokeAggregate);
    }

  }

  @Override
  public CsrfToken loadToken(HttpServletRequest request) {
    String identifier = request.getHeader("X-IDENTIFIER");
    Optional<Token> existingToken = tokenDataProvider.getToken(identifier);
    return existingToken.map(tokenEntity -> new DefaultCsrfToken("X-CSRF-TOKEN","_csrf", tokenEntity.getToken()))
        .orElse(null);
  }
}
