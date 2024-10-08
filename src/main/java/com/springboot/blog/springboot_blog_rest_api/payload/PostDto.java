package com.springboot.blog.springboot_blog_rest_api.payload;

import java.util.List;

import com.springboot.blog.springboot_blog_rest_api.entity.Post;

import lombok.Data;

@Data
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;
    
    public PostDto(List<Post> posts) {
        //TODO Auto-generated constructor stub
    }
    public PostDto() {
        //TODO Auto-generated constructor stub
    }
}
