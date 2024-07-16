package com.example.Digital_Chief_TZ.service;


import com.example.Digital_Chief_TZ.model.Post;
import com.example.Digital_Chief_TZ.repository.PostRepository;
import com.example.Digital_Chief_TZ.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    @Transactional
    public void addPost(Long user_id, String text) {
        Post post = new Post();
        post.setText(text);
        post.setUser(userRepository.findById(user_id).orElse(null));
        postRepository.save(post);
    }

    @Override
    @Transactional
    public void updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id).orElse(null);
        if(post != null){
            post.setText(postDetails.getText());
        }
        else {
            throw new NullPointerException();
        }
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
