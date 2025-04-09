package com.products.infrastructure.adapter.user;



import com.products.infrastructure.entities.User;
import com.products.infrastructure.repositories.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDataProviderImp implements UserDataProvider {
  private final UserRepository userRepository;
  @Override
  public Optional<User> findUserByUserName(String u) {
    return userRepository.findUserByUsername(u);
  }


}
