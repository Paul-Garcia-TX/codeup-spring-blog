package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.interfaces.PostRepository;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, EmailService emailService) {
        this.postDao = postDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String getPosts(Model model) {
        // Replace with your logic to retrieve posts from the database
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable long id, Model model) {
        // Replace with your logic to retrieve a specific post from the database
        Post post = postDao.getReferenceById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost1() {
        return "redirect:/index";
    }
}
