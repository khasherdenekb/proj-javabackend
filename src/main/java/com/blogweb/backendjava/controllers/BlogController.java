package com.blogweb.backendjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogweb.backendjava.models.BlogModel;
import com.blogweb.backendjava.services.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<BlogModel> getAllPosts() {
        return blogService.getAllPosts();
    }

    @GetMapping("/{id}")
    public BlogModel getPostById(@PathVariable Long id) {
        return blogService.getPostById(id).orElse(null);
    }

    @PostMapping
    public BlogModel createPost(@RequestBody BlogModel post) {
        return blogService.savePost(post);
    }

    @PutMapping("/{id}")
    public BlogModel updatePost(@PathVariable Long id, @RequestBody BlogModel post) {
        post.setId(id);
        return blogService.savePost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        blogService.deletePost(id);
    }
}