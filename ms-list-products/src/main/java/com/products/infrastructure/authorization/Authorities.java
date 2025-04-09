package com.products.infrastructure.authorization;

import com.products.infrastructure.entities.User;
import lombok.Data;

@Data

public class Authorities {

  private Integer id;

  private String name;


  private User user;

}
