package com.jadmak.domain;

import java.util.List;

 public record Order(
        String orderId,
        Customer customer,
        Merchant merchant,
        List<Item> items
        ) {
}
