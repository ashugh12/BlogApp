package com.springboot.blog.springboot_blog_rest_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //automatically generate generate getter, setter and constructor
@AllArgsConstructor //generate all-args constructor
@NoArgsConstructor

@Entity //specifies that class is an entity
@Table(
    name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = "title")}
)
public class Post {

    @Id // to specify primary key to our entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // to specify primary key strategy
    private long id;

    @Column(name="title", nullable = false) 
    private String title;
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="content", nullable = false)
    private String content;

    public Post(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
