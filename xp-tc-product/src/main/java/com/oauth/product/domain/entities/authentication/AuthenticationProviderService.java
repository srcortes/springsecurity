package com.oauth.product.domain.entities.authentication;


import lombok.AllArgsConstructor;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AuthenticationProviderService implements AuthenticationProvider {


  private final JpaUserDetailService jpaUserDetailService;


  private final BCryptPasswordEncoder bCryptPasswordEncoder;


  private final SCryptPasswordEncoder sCryptPasswordEncoder;



  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String userName = authentication.getName();
    String password = authentication.getCredentials().toString();
    CustomUserDetails user = jpaUserDetailService.loadUserByUsername(userName);
    return checkAlgorithm(user, password);
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return UsernamePasswordAuthenticationToken.class
        .isAssignableFrom(aClass);
  }

  private Authentication checkAlgorithm(CustomUserDetails user, String password){
    switch (user.getUsers().getAlgorithm()){
      case BCRYPT -> {
        return checkPassword(user, password, bCryptPasswordEncoder);
      }
      case SCRYPT -> {
        return checkPassword(user, password, sCryptPasswordEncoder);
      }
    }
    throw new BadCredentialsException("Something go wrong....");
  }

  private Authentication checkPassword(CustomUserDetails user, String rawPassowrd,
      PasswordEncoder encoder){
    if(encoder.matches(rawPassowrd, user.getPassword())){
      return new UsernamePasswordAuthenticationToken(user.getUsername(),
          user.getPassword(), user.getAuthorities());
    }else{
      throw new BadCredentialsException("Something go wrong....");
    }
  }
}
