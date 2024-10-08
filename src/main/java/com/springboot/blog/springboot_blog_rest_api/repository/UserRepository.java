package com.springboot.blog.springboot_blog_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.blog.springboot_blog_rest_api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom queries if needed
}
