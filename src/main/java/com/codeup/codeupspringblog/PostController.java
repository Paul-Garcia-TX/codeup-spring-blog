package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String getPosts(){
        return "This is the posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getPostsID(@PathVariable String id){
        return "This is post ID: " + id;

    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "Viewing the creation form";

    }

}
