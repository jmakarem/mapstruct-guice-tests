package com.jadmak.mapper;

import com.jadmak.domain.Item;
import com.jadmak.dto.OrderDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper
public interface ItemMapper {

    @Mapping(target = "itemSKU", source = "sku")
    @Mapping(target = "itemName", source = "name")
    @Mapping(target = "itemPrice", source = "price")
    OrderDetailsDto.ItemDto toItemDto(Item item);

}
