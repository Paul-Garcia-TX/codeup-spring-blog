package com.codeup.codeupspringblog.interfaces;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List <Post> findPostsByUser(User user);

    Post findById(long id);

}
