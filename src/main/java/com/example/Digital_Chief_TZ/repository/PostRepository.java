package com.example.Digital_Chief_TZ.repository;

import com.example.Digital_Chief_TZ.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
