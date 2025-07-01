package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.service.CategoryService;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listPosts(@PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("posts", postService.getAllPosts(pageable));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "posts/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "posts/create";
    }

    @PostMapping
    public String createPost(@ModelAttribute Post post, @RequestParam Long categoryId) {
        postService.createPost(post, categoryId);
        return "redirect:/posts";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "posts/edit";
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post post, @RequestParam Long categoryId) {
        postService.updatePost(id, post, categoryId);
        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }

    @GetMapping("/view/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "posts/view";
    }

    @GetMapping("/search")
    public String searchPosts(@RequestParam String title, @PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("posts", postService.searchPostsByTitle(title, pageable));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("searchTitle", title);
        return "posts/list";
    }

    @GetMapping("/category/{categoryId}")
    public String listPostsByCategory(@PathVariable Long categoryId, @PageableDefault(size = 5) Pageable pageable, Model model) {
        model.addAttribute("posts", postService.getPostsByCategory(categoryId, pageable));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "posts/list";
    }
}
