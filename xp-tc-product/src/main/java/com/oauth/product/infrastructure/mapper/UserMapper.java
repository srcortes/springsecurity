package com.oauth.product.infrastructure.mapper;

import com.oauth.product.infrastructure.adapter.out.entity.User;
import com.oauth.product.domain.entities.dto.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
  Users mapUser(User user);

}
