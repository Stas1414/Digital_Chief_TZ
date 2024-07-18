package com.example.Digital_Chief_TZ.service;

import com.example.Digital_Chief_TZ.dto.PostDto;
import com.example.Digital_Chief_TZ.dto.UserDto;
import com.example.Digital_Chief_TZ.model.Post;
import com.example.Digital_Chief_TZ.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    UserDto showUser(Long id);
    void addUser(User userDetails);
    void updateUser(Long id,User userDetails);
    void deleteUser(Long id);
    List<PostDto> showUsersPost(Long id);
}
