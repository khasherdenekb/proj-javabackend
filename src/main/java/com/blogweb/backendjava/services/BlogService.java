package com.blogweb.backendjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogweb.backendjava.models.BlogModel;
import com.blogweb.backendjava.repository.BlogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<BlogModel> getAllPosts() {
        return blogRepository.findAll();
    }

    public Optional<BlogModel> getPostById(Long id) {
        return blogRepository.findById(id);
    }

    public BlogModel savePost(BlogModel post) {
        return blogRepository.save(post);
    }

    public void deletePost(Long id) {
        blogRepository.deleteById(id);
    }
}
