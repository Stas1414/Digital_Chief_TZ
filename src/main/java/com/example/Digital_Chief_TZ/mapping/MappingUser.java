package com.example.Digital_Chief_TZ.mapping;

import com.example.Digital_Chief_TZ.dto.UserDto;
import com.example.Digital_Chief_TZ.model.User;
import org.springframework.stereotype.Service;

@Service
public class MappingUser {

    public UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public User mapToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        return user;
    }
}
