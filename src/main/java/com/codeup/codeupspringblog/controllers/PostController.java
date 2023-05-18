package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String getPosts(Model model) {
        // Add model attributes for posts data
        // Example:
        List<Post> posts = yourMethodToRetrievePosts(); // Replace with your logic to retrieve posts from the database
        model.addAttribute("posts", posts);

        return "index";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable int id, Model model) {
        // Add model attributes for the specific post data
        // Example:
        Post post = yourMethodToRetrievePostById(id); // Replace with your logic to retrieve a specific post from the database
        model.addAttribute("post", post);

        return "show";
    }

    @GetMapping("/posts/create")
    public String createPost() {
        return "create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost1() {
        return "You're seeing the form";
    }

    private List<Post> yourMethodToRetrievePosts() {
        // Implement your logic to retrieve posts from the database
        // Return a list of Post objects
        // This is just a placeholder implementation
        return null;
    }

    private Post yourMethodToRetrievePostById(int id) {
        // Implement your logic to retrieve a specific post from the database based on the given ID
        // Return a Post object
        // This is just a placeholder implementation
        return null;
    }
}
