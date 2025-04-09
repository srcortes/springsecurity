package com.products.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;

@Data
public class ProductDto {

  @NonNull
  @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
  private String name;
  @NonNull
  private double price;
  @NonNull
  private CurrenciesDTO currency;
}
