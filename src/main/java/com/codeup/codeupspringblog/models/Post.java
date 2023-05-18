package com.codeup.codeupspringblog.models;


import jakarta.persistence.*;

@Entity
@Table(name="Post")
public class Post {



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 255)
    private String title;

    @Column(nullable = false)
    private String body;
}

