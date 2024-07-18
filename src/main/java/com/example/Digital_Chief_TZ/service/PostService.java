package com.example.Digital_Chief_TZ.service;

import com.example.Digital_Chief_TZ.dto.PostDto;
import com.example.Digital_Chief_TZ.model.Post;

import java.util.List;

public interface PostService {

    PostDto getPostById(Long id);
    List<PostDto> getAllPosts();
    void addPost(Long user_id,String text);
    void updatePost(Long id,Post postDetails);
    void deletePost(Long id);
}
