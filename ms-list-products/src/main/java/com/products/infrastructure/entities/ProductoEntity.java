package com.products.infrastructure.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.Data;

@Entity(name = "product")
@Data
public class ProductoEntity {

  @Id
  private Integer id;
  private String name;
  private double price;

  @Enumerated(EnumType.STRING)
  private Currencies currency;


}
