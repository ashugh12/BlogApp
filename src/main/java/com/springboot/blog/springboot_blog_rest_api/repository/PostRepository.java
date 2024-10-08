package com.springboot.blog.springboot_blog_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.springboot_blog_rest_api.entity.Post;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    // This is a comment
}
