package com.amemais.model;

import javax.persistence.*;

@Entity
@Table(name = "administrador")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "username", unique = true)
    String username = "admin";
    @Column(name = "password", unique = true)
    String password = "admin";

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

