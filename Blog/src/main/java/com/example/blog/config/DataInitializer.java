package com.example.blog.config;

import com.example.blog.model.Category;
import com.example.blog.model.Post;
import com.example.blog.repository.CategoryRepository;
import com.example.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Tạo danh mục mẫu
        Category tech = new Category();
        tech.setName("Technology");
        categoryRepository.save(tech);

        Category lifestyle = new Category();
        lifestyle.setName("Lifestyle");
        categoryRepository.save(lifestyle);

        // Tạo bài viết mẫu
        Post post1 = new Post();
        post1.setTitle("Introduction to Spring Boot");
        post1.setContent("This is a blog post about Spring Boot.");
        post1.setCategory(tech);
        post1.setCreatedAt(java.time.LocalDateTime.now());
        postRepository.save(post1);

        Post post2 = new Post();
        post2.setTitle("Healthy Living Tips");
        post2.setContent("Tips for a healthy lifestyle.");
        post2.setCategory(lifestyle);
        post2.setCreatedAt(java.time.LocalDateTime.now());
        postRepository.save(post2);
    }
}