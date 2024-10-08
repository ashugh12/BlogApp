package com.springboot.blog.springboot_blog_rest_api.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

import com.springboot.blog.springboot_blog_rest_api.entity.Post;
import com.springboot.blog.springboot_blog_rest_api.exception.ResourceNotFoundException;
import com.springboot.blog.springboot_blog_rest_api.payload.PostDto;
import com.springboot.blog.springboot_blog_rest_api.repository.PostRepository;
import com.springboot.blog.springboot_blog_rest_api.service.PostService;


@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    public  PostServiceImpl(PostRepository postRepository){
        this.postRepository=postRepository;
    }
    @Override
    public PostDto createPost(@RequestBody PostDto postDto) {
        //converting DTO to entity
        Post post = maptoPost(postDto);

        Post newPost=postRepository.save(post);

        //convert  entity to Dto

        PostDto postResponse= mapToDto(newPost);
        System.out.println(postResponse);

        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts=postRepository.findAll();
        List<PostDto> postDto= posts.stream().map((post)-> mapToDto(post)).collect(Collectors.toList());
        System.out.println(postDto);
        return postDto;
    }

    public PostDto mapToDto(Post post){
        PostDto postDto=new PostDto();
        postDto.setId(post.getId());
        postDto.setContent(post.getContent());
        postDto.setDescription(post.getDescription());
        postDto.setTitle(post.getTitle());
        // System.out.println(postDto);
        return postDto;
    }

    public Post maptoPost(PostDto postDto){

        Post post=new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        // System.out.println(post);
        return post;

    }

    @Override
    public PostDto getPostById(long id){
        Post post=postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }
    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post=postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post updatedPost=postRepository.save(post);

        return mapToDto(updatedPost);
    }

    @Override
    public PostDto deletePost(long id){

        Post post=postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));

        postRepository.deleteById(id);

        return mapToDto(post);
    }
    @Override
    public List<PostDto> deleteAllPosts() {
        postRepository.deleteAll();
        return null;
    }
}
