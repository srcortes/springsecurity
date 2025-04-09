package com.oauth.product.domain.entities.authentication;


import com.oauth.product.infrastructure.adapter.out.adapter.DataProvider;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaUserDetailService implements UserDetailsService {

  private final DataProvider dataProvider;



  @Override
  public CustomUserDetails loadUserByUsername(String username) throws
      UsernameNotFoundException {
    return Optional.ofNullable(dataProvider.findUserByUserName(username))
        .map(CustomUserDetails::new)
        .orElseThrow(()->  new UsernameNotFoundException("Error during authentication"));
  }
}
