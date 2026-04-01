package com.example.chapter4.mapper;

import com.example.chapter4.dto.request.RequestUser;
import com.example.chapter4.dto.response.ResponseUser;
import com.example.chapter4.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(RequestUser request);

    ResponseUser toResponse(User user);

}
