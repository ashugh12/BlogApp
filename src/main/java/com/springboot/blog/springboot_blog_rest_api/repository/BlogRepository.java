package com.springboot.blog.springboot_blog_rest_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.blog.springboot_blog_rest_api.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    // Custom methods if needed
}
