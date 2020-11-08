package com.example.tacos;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
public class Order {

  @NotBlank(message="Pole wymagane")
  private String name;

  @NotBlank(message="Pole wymagane")
  private String street;

  @NotBlank(message="Pole wymagane")
  private String city;

  @NotBlank(message="Pole wymagane")
  private String state;

  @NotBlank(message="Pole wymagane")
  private String zip;

  @CreditCardNumber(message="Zły numer karty kredytowej")
  private String ccNumber;

  @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
           message="Format: MM/YY")
  private String ccExpiration;

  @Digits(integer=3, fraction=0, message="Błędny kod CVV")
  private String ccCVV;

}
