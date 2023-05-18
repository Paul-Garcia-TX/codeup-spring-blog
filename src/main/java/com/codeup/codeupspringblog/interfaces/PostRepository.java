package com.codeup.codeupspringblog.interfaces;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("FROM Post WHERE id = :id")
    Post getPostById(@Param("id") long id);

    @Query("FROM Post WHERE title LIKE %:term%")
    List<Post> searchByTitleLike(@Param("term") String term);
}
