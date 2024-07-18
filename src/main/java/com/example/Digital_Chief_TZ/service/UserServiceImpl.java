package com.example.Digital_Chief_TZ.service;

import com.example.Digital_Chief_TZ.dto.PostDto;
import com.example.Digital_Chief_TZ.dto.UserDto;
import com.example.Digital_Chief_TZ.mapping.MappingPost;
import com.example.Digital_Chief_TZ.mapping.MappingUser;
import com.example.Digital_Chief_TZ.model.Post;
import com.example.Digital_Chief_TZ.model.User;
import com.example.Digital_Chief_TZ.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private MappingUser mappingUser;

    private MappingPost mappingPost;

    public UserServiceImpl(UserRepository userRepository, MappingUser mappingUser, MappingPost mappingPost) {
        this.userRepository = userRepository;
        this.mappingUser = mappingUser;
        this.mappingPost = mappingPost;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> finalUsers = new ArrayList<>();
        for (User user : users) {
            finalUsers.add(mappingUser.mapToUserDto(user));
        }
        return finalUsers;
    }

    @Override
    public UserDto showUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException("the entity was not found"));
        return mappingUser.mapToUserDto(user);

    }

    @Override
    @Transactional
    public void addUser(User userDetails) {
        User user = new User();
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException("the entity was not found"));
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<PostDto> showUsersPost(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException("the entity was not found"));
        List<Post> usersPost = user.getPosts();
        List<PostDto> finalPosts = new ArrayList<>();
        for (Post post : usersPost) {
            finalPosts.add(mappingPost.mapToPostDto(post));
        }
        return finalPosts;
    }
}
