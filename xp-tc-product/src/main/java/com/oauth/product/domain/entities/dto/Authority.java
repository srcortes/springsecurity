package com.oauth.product.domain.entities.dto;

import com.oauth.product.infrastructure.adapter.out.entity.User;
import lombok.Data;


@Data
public class Authority {
  private Integer Id;

  private String name;


  private User user;

}
