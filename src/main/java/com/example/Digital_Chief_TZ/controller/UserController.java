package com.example.Digital_Chief_TZ.controller;


import com.example.Digital_Chief_TZ.model.Post;
import com.example.Digital_Chief_TZ.model.User;
import com.example.Digital_Chief_TZ.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Post>> getUsersPost(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.showUsersPost(id));
    }

    @PostMapping("/new")
    public ResponseEntity<Void> createUser(@RequestBody User userDetails){
        userService.addUser(userDetails);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") Long id,@RequestBody User userDetails){
        userService.updateUser(id,userDetails);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
