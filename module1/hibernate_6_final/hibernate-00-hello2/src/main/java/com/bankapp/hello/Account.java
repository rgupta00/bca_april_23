package com.bankapp.hello;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "acc_table")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
 public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 40)
    private String name;
    //XXXX.44
    @Column(nullable = false, precision = 8)
    private BigDecimal balance;

   public Account(String name, BigDecimal balance) {
      this.name = name;
      this.balance = balance;
   }
}
