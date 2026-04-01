package com.example.chapter4.mapper;

import com.example.chapter4.dto.request.RequestOrder;
import com.example.chapter4.dto.response.ResponseOrder;
import com.example.chapter4.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { CoffeeMapper.class, UserMapper.class })
public interface OrderMapper {

    Order toEntity(RequestOrder requestOrder);

    ResponseOrder toResponse(Order order);

}
