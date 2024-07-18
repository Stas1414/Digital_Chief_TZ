package com.example.Digital_Chief_TZ.mapping;

import com.example.Digital_Chief_TZ.dto.PostDto;
import com.example.Digital_Chief_TZ.model.Post;
import org.springframework.stereotype.Service;

@Service
public class MappingPost {

    public PostDto mapToPostDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setText(post.getText());
        return postDto;
    }

    public Post mapToPost(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setText(postDto.getText());
        return post;
    }
}
