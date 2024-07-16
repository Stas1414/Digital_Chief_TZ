package com.example.Digital_Chief_TZ.controller;

import com.example.Digital_Chief_TZ.model.Post;
import com.example.Digital_Chief_TZ.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping("/new/{users_id}")
    public ResponseEntity<Void> createNewPost(@RequestBody Post postDetails,@PathVariable ("users_id") Long users_id){
        postService.addPost(users_id,postDetails.getText());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable("id") Long id,@RequestBody Post postDetails){
        postService.updatePost(id,postDetails);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
