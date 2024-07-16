package com.example.Digital_Chief_TZ.service;

import com.example.Digital_Chief_TZ.model.Post;
import com.example.Digital_Chief_TZ.model.User;
import com.example.Digital_Chief_TZ.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User showUser(Long id) {
        return userRepository.findById(id).orElse(null);
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
    public void updateUser(Long id,User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            userRepository.save(user);
        }
        else{
            throw new NullPointerException();
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Post> showUsersPost(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null){
            return user.getPosts();
        }
        else {
            throw new NullPointerException();
        }
    }
}
