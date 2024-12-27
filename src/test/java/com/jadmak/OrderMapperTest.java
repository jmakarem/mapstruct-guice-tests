package com.jadmak;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jadmak.domain.Customer;
import com.jadmak.domain.Item;
import com.jadmak.domain.Merchant;
import com.jadmak.domain.Order;
import com.jadmak.dto.OrderDetailsDto;
import com.jadmak.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderMapperTest {

    static final Injector INJECTOR = Guice.createInjector(new AppModule());
    public OrderMapper orderMapperGuice =  INJECTOR.getInstance(OrderMapper.class);
    public OrderMapper orderMapperMapStruct = Mappers.getMapper(OrderMapper.class);


    @Test
    void testGuice(){
        testOrderMapper(orderMapperGuice);
    }

    @Test
    void testMapStruct(){
        testOrderMapper(orderMapperMapStruct);
    }

    static void testOrderMapper(OrderMapper orderMapper) {
        String customerId = "customerId";
        String customerName ="customerName";
        String customerAddress ="customerAddress";
        String merchantId = "merchantId";
        String merchantName = "merchantName";
        String merchantAddress = "merchantAddress";
        String sku1 = "sku1";
        String name1 = "name1";
        BigDecimal price1 = BigDecimal.valueOf(10.00);
        String sku2 ="sku2";
        String name2 = "name2";
        BigDecimal price2 = BigDecimal.valueOf(32.00);
        String orderId = "orderId";

        Customer customer = new Customer(customerId, customerName, customerAddress);
        Merchant merchant = new Merchant(merchantId, merchantName, merchantAddress);
        Item item1 = new Item(sku1,name1,price1);
        Item item2 = new Item(sku2,name2,price2);

        Order order = new Order(orderId,customer,merchant, List.of(item1,item2));

        OrderDetailsDto mappedOrder = orderMapper.toDto(order);

        List<OrderDetailsDto.ItemDto> expectedItems = Stream.of(item1,item2).map(it -> new OrderDetailsDto.ItemDto(it.name(),it.sku(),it.price().doubleValue())).toList();
        OrderDetailsDto expectedOrderDto = new OrderDetailsDto(orderId,customerName,customerId ,customerAddress, merchantId, merchantName, merchantAddress,expectedItems);

        assertThat(mappedOrder).isEqualTo(expectedOrderDto);
    }
}
