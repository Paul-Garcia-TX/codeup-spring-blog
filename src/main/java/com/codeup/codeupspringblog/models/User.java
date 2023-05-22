package com.codeup.codeupspringblog.models;


import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    public String username;

    @Column(nullable = false, length = 255)
    private String email;


    @Column(nullable = false, length = 255)
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public void setId(int id) {
        this.id = id;
    }
    public int getId(int id){
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


    protected String getPassword(String password){
        return password;
    }
    protected void setPassword(String password){
        this.password = password;
    }
}
