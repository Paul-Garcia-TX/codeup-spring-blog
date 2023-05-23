package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.interfaces.PostRepository;
import com.codeup.codeupspringblog.interfaces.UserRepository;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final EmailService emailService;

    private final UserRepository userRepository;


    public PostController(PostRepository postDao, EmailService emailService, PostRepository postRepository, UserRepository userRepository) {
        this.postDao = postDao;
        this.emailService = emailService;
        this.userRepository = userRepository;
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
    public String createPost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
//work on this one below
@PostMapping("/posts/create")
public String createPost1(@ModelAttribute Post post) {
    User user = userRepository.findById(1L); // Assuming 1 is the user_id of the desired user
    post.setUser(user);
    postDao.save(post);

    return "redirect:/posts";
}



    @GetMapping("/posts/email/{id}")
    public String sendEmailAboutPost(@PathVariable long id) {
        Optional<Post> optionalPost = Optional.ofNullable(postDao.findById(id));
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            emailService.prepareAndSend(post, "Here's the post you requested", post.getTitle() + " : " + post.getBody() + " ~ creator: " + post.getUser());
        }
        return "redirect:/posts";
    }


}
