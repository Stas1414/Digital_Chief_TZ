package com.example.Digital_Chief_TZ.service;

import com.example.Digital_Chief_TZ.model.Post;
import com.example.Digital_Chief_TZ.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User showUser(Long id);
    void addUser(String username,String email);
    void updateUser(Long id,User userDetails);
    void deleteUser(Long id);
    List<Post> showUsersPost(Long id);
}
