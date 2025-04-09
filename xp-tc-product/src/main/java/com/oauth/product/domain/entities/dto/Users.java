package com.oauth.product.domain.entities.dto;

import java.util.List;
import lombok.Data;

@Data
public class Users {

  private Integer Id;

  private String userName;

  private String password;

  private EncryptionAlgorithm algorithm;

  private List<Authority> authorities;

}
