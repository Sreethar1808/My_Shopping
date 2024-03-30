package com.My_Shopping.My_Shopping.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column(nullable = false)
    String name;
    @Column(unique = true, nullable = false)
    String email;
    @Column(nullable = false)
    String password;
    String usertype;
    @Column(unique = true, length = 10)
    Long phonenumber;

    public AppUser() {
    }

    public AppUser(UUID id, String name, String email, String password, String usertype, Long phonenumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
        this.phonenumber = phonenumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }
}
