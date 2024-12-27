package com.jadmak.mapper;


import com.jadmak.domain.Item;
import com.jadmak.domain.Order;
import com.jadmak.dto.OrderDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper   (
        uses = ItemMapper.class
)
public interface OrderMapper {

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "customerName", source = "customer.name")
    @Mapping(target = "customerAddress", source = "customer.address")
    @Mapping(target = "merchantId", source = "merchant.id")
    @Mapping(target = "merchantName", source = "merchant.name")
    @Mapping(target = "merchantAddress", source = "merchant.address")
    OrderDetailsDto toDto(Order order);
}
