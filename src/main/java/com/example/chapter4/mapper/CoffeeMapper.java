package com.example.chapter4.mapper;

import com.example.chapter4.dto.request.RequestGetCoffee;
import com.example.chapter4.dto.response.ResponseGetCoffee;
import com.example.chapter4.model.Coffee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {

    Coffee toEntity(RequestGetCoffee request);

    ResponseGetCoffee toResponse(Coffee coffee);

}
