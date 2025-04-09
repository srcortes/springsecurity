package com.products.infrastructure.authorization.provider;

import com.products.infrastructure.authorization.filters.AuthenticationLoggingFilter;
import com.products.infrastructure.authorization.filters.CsrfTokenLogger;
import com.products.infrastructure.authorization.filters.CustomCsrfToken;
import com.products.infrastructure.authorization.filters.RequestValidationFilter;
import com.products.infrastructure.authorization.services.AuthenticationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthenticationProviderService authenticationProviderService;

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SCryptPasswordEncoder sCryptPasswordEncoder(){
    return new SCryptPasswordEncoder();
  }

  @Bean
  public CsrfTokenRepository customTokenRepository(){
    return new CustomCsrfToken();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
      auth.authenticationProvider(authenticationProviderService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.httpBasic();
    http
        .addFilterBefore(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)//Adding filter after authentication
        .addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class)
        .addFilterAt(new RequestValidationFilter(), BasicAuthenticationFilter.class)//Adding filter at authentication
        .authorizeRequests()
        //.mvcMatchers("/updateProduct/**").hasAuthority("ADMIN")
        .mvcMatchers("/updateProduct/**").hasRole("ADMIN")
        .mvcMatchers(HttpMethod.GET, "/products").hasRole("MANAGER")
        .mvcMatchers(HttpMethod.GET, "/products/**").hasRole("ADMIN");
        //.anyRequest().hasRole("MANAGER") //this is a way to allow access
    //http.csrf(c-> c.ignoringAntMatchers("/updateProduct/**"));//Here we are ignoring csrf for this endpoint
    http.csrf(c ->{
      c.csrfTokenRepository(customTokenRepository());
      c.ignoringAntMatchers("/updateProduct/");
    });




  }
}
