package com.products.infrastructure.authorization.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;

public class RequestValidationFilter implements Filter {

  @Value("${authorization.key}")
  private String authorizationKey;
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    var httpRequest = (HttpServletRequest) request;
    var httpResponse = (HttpServletResponse) response;
    String requestId = httpRequest.getHeader("Request-Id");
    String authorization = httpRequest.getHeader("Authorization-Key");


    if (authorization == null || authorization.isBlank() || !authorization.equals(authorizationKey)) {
      httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }


    if (requestId == null || requestId.isBlank()) {
      httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }
    filterChain.doFilter(request, response);
  }
}
