package com.jadmak.dto;

import java.util.List;

public record OrderDetailsDto(
        String orderId,
        String customerName,
        String customerId,
        String customerAddress,
        String merchantId,
        String merchantName,
        String merchantAddress,
        List<ItemDto> items) {

    public record ItemDto(
            String itemName,
            String itemSKU,
            double itemPrice
    ) {
    }

}
