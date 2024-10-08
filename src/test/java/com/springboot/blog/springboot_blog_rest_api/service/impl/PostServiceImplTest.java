package com.springboot.blog.springboot_blog_rest_api.service.impl;

import com.springboot.blog.springboot_blog_rest_api.entity.Post;
import com.springboot.blog.springboot_blog_rest_api.payload.PostDto;
import com.springboot.blog.springboot_blog_rest_api.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PostServiceImplTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    private PostDto postDto;
    private Post post;

    @BeforeEach
    public void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Set up test data
        postDto = new PostDto();
        postDto.setId(1L);
        postDto.setTitle("Test Title");
        postDto.setContent("Test Content");

        post = new Post();
        post.setId(1L);
        post.setTitle("Test Title");
        post.setContent("Test Content");
    }

    @Test
    public void testCreatePost() {
        // Mock the repository's save method
        when(postRepository.save(any(Post.class))).thenReturn(post);

        // Call the method under test
        PostDto createdPost = postService.createPost(postDto);

        // Assert that the post was created correctly
        assertNotNull(createdPost);
        assertEquals(postDto.getTitle(), createdPost.getTitle());
        assertEquals(postDto.getContent(), createdPost.getContent());

        // Verify that the repository's save method was called once
        verify(postRepository, times(1)).save(any(Post.class));
    }

    @Test
    public void testGetAllPosts() {
        // Mock the repository's findAll method
        when(postRepository.findAll()).thenReturn(Collections.singletonList(post));

        // Call the method under test
        List<PostDto> allPosts = postService.getAllPosts();

        // Assert the result
        assertEquals(1, allPosts.size());
        assertEquals(postDto.getTitle(), allPosts.get(0).getTitle());

        // Verify that the repository's findAll method was called once
        verify(postRepository, times(1)).findAll();
    }

    @Test
    public void testGetPostById() {
        // Mock the repository's findById method
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        // Call the method under test
        PostDto foundPost = postService.getPostById(1L);

        // Assert that the post was found
        assertNotNull(foundPost);
        assertEquals(postDto.getTitle(), foundPost.getTitle());

        // Verify that the repository's findById method was called once
        verify(postRepository, times(1)).findById(1L);
    }

    @Test
    public void testUpdatePost() {
        // Mock the repository's findById and save methods
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(postRepository.save(any(Post.class))).thenReturn(post);

        // Call the method under test
        PostDto updatedPost = postService.updatePost(postDto, 1L);

        // Assert that the post was updated correctly
        assertNotNull(updatedPost);
        assertEquals(postDto.getTitle(), updatedPost.getTitle());

        // Verify the interactions with the repository
        verify(postRepository, times(1)).findById(1L);
        verify(postRepository, times(1)).save(any(Post.class));
    }

    @Test
    public void testDeletePost() {
        // Mock the repository's findById and deleteById methods
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        doNothing().when(postRepository).deleteById(1L);

        // Call the method under test
        postService.deletePost(1L);

        // Verify that the repository's findById and deleteById methods were called once
        verify(postRepository, times(1)).findById(1L);
        verify(postRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteAllPosts() {
        // Mock the repository's deleteAll method
        doNothing().when(postRepository).deleteAll();

        // Call the method under test
        postService.deleteAllPosts();

        // Verify that the repository's deleteAll method was called once
        verify(postRepository, times(1)).deleteAll();
    }
}
