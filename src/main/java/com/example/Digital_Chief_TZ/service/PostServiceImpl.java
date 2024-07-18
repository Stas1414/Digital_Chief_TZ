package com.example.Digital_Chief_TZ.service;


import com.example.Digital_Chief_TZ.dto.PostDto;
import com.example.Digital_Chief_TZ.mapping.MappingPost;
import com.example.Digital_Chief_TZ.model.Post;
import com.example.Digital_Chief_TZ.repository.PostRepository;
import com.example.Digital_Chief_TZ.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private UserRepository userRepository;

    private MappingPost mappingPost;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, MappingPost mappingPost) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.mappingPost = mappingPost;
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new NullPointerException("the object was not found"));
        return mappingPost.mapToPostDto(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> finalPosts = new ArrayList<>();
        for (Post post : posts) {
            finalPosts.add(mappingPost.mapToPostDto(post));
        }
        return finalPosts;
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
        Post post = postRepository.findById(id).orElseThrow(() -> new NullPointerException("the object was not found"));
        post.setText(postDetails.getText());
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
