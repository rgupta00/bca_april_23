package com.bankapp.pk;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
 public class Address {


   private Integer id;

   private String city;

    private String address;

    public Address(String city, String address) {
        this.city = city;
        this.address = address;
    }
}

