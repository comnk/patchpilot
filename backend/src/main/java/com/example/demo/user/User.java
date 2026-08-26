package com.example.demo.user;

import java.util.Date;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class User {
    @Id
    private Long id;

    @Getter
    @Setter
    private String name;

    @Setter
    private Date createdAt;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}