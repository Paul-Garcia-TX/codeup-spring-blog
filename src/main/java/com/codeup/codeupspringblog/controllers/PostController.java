package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String getPosts(Model model) {
        // Replace with your logic to retrieve posts from the database
        List<Post> posts = yourMethodToRetrievePosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable long id, Model model) {
        // Replace with your logic to retrieve a specific post from the database
        Post post = yourMethodToRetrievePostById(id);
        model.addAttribute("post", post);
        return "show";
    }

    @GetMapping("/posts/create")
    public String createPost() {
        return "create";
    }

    @PostMapping("/posts/create")
    public String createPost1() {

        return "redirect:/index";
    }

    private List<Post> yourMethodToRetrievePosts() {

        return null;
    }

    private Post yourMethodToRetrievePostById(long id) {

        return null;
    }
    @GetMapping("/rick-roll")
    public String rickRoll() {
        // redirecting to an absolute url
        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    }
    @GetMapping("/redirect-me")
    public String redirect() {
        // a relative (to the base domain) redirect, usually you will use this
        // version
        // Will redirect the users to `/about`
        return "redirect:/about";
    }

}
