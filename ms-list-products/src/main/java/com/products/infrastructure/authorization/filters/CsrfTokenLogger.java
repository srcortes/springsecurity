package com.products.infrastructure.authorization.filters;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.security.web.csrf.CsrfToken;

public class CsrfTokenLogger implements Filter {
  private final Logger logger = Logger.getLogger(CsrfTokenLogger.class.getName());


  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain filterChain) throws IOException, ServletException {
    Object o = request.getAttribute("_csrf");
    CsrfToken csrfToken = (CsrfToken) o;

    logger.info("CSRF Token: " + csrfToken.getToken());
    filterChain.doFilter(request, response);

  }
}
