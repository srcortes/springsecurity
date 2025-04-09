package com.products.domain.aggregates;


import com.products.domain.valueobjects.Currencies;
import lombok.Getter;


import java.util.UUID;

@Getter
public class ProductAggregate  {

    private String Id;
    private String name;
    private double price;
    private Currencies currency;

    private ProductAggregate(String id, String name, double price, Currencies currency) {

        Id = id;
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    private static void validatePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }

    private static void isValidCurrency(String currency) {
        try {
            Currencies.valueOf(currency);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid currency: " + currency);
        }
    }

    private static String generateId(String name) {
        return "770".concat(String.valueOf(name.length()).concat(UUID.randomUUID().toString()));
    }

    public static ProductAggregate createProduct(String name, double price, String currency) {
        validatePrice(price);
        isValidCurrency(currency);
        return new ProductAggregate(generateId(name), name, price, Currencies.valueOf(currency));
    }
}

