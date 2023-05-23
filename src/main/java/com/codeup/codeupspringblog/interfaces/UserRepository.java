package com.codeup.codeupspringblog.interfaces;


import com.codeup.codeupspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{


        User findById(long id);

}
