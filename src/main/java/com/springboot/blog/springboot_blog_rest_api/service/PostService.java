package com.springboot.blog.springboot_blog_rest_api.service;

import java.util.List;


import com.springboot.blog.springboot_blog_rest_api.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
    
    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    PostDto deletePost(long id);

    List<PostDto> deleteAllPosts();
}
