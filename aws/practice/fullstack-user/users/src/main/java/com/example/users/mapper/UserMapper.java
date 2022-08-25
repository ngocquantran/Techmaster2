package com.example.users.mapper;

import com.example.users.dto.UserDto;
import com.example.users.model.User;

public class UserMapper {
    public static UserDto toUserDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getAddress(), user.getAvatar());
    }


}
