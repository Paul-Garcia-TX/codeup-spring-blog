package com.codeup.codeupspringblog.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "User")
public class User  {

    public User(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    public String username;

    @Column(nullable = false, length = 255)
    private String email;


    @Column(nullable = false, length = 500)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;


    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }


    public String getUsername(String username){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getEmail(String email){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }


    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }
}
