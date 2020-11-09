package com.example.tacos;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

@Data
@Entity
@Table(name="Taco_Order")
public class Order implements Serializable {


  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Date placedAt;

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

  @ManyToMany(targetEntity = Taco.class)
  private List<Taco> tacos = new ArrayList<>();

  public void addDesign(Taco design) {
    this.tacos.add(design);
  }
  @PrePersist
  void placedAt(){
    this.placedAt = new Date();
  }

}
