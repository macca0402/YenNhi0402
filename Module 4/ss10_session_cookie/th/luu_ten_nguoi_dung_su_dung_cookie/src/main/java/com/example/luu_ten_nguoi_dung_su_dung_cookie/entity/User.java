package com.example.luu_ten_nguoi_dung_su_dung_cookie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class User {
    @Id
    private String email;
    private String password;

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

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
