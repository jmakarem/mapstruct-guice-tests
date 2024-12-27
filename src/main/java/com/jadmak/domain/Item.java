package com.jadmak.domain;

import java.math.BigDecimal;

 public record Item(
        String sku,
        String name,
        BigDecimal price
){}
