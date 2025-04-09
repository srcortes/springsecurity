package com.oauth.product.infrastructure.adapter.out.repository;

import com.oauth.product.infrastructure.adapter.out.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findUserByUsername(String u);
}
