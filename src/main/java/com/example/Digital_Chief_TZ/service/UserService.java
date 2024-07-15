package com.example.Digital_Chief_TZ.service;

import com.example.Digital_Chief_TZ.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(String username,String email);
    void updateUser(Long id,User userDetails);

    void deleteUser(Long id);
}
