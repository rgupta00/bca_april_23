package com.bankapp.hello;

import java.math.BigDecimal;

public record AccountDto(String name, BigDecimal balance) {
}
