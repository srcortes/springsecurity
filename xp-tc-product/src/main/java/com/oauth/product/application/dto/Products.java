package com.oauth.product.application.dto;

import com.oauth.product.infrastructure.adapter.out.entity.Currency;
import lombok.Data;

@Data
public class Products {
  private Integer id;
  private String name;
  private double price;
  private Currency currency;
}
