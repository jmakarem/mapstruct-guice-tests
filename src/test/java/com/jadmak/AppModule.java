package com.jadmak;

import com.google.inject.AbstractModule;
import com.jadmak.mapper.ItemMapper;
import com.jadmak.mapper.ItemMapperImpl;
import com.jadmak.mapper.OrderMapper;
import com.jadmak.mapper.OrderMapperImpl;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ItemMapper.class).to(ItemMapperImpl.class);
        bind(OrderMapper.class).to(OrderMapperImpl.class);
    }
}