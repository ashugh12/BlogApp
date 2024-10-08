package com.springboot.blog.springboot_blog_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

    //http://localhost:8080
    @GetMapping
    public String check(){
        return "HELLO WORLD!";
    }
}
