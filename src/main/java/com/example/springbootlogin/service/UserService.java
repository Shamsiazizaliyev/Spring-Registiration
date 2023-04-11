package com.example.springbootlogin.service;


import com.example.springbootlogin.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    public Optional<User> login(String email, String password);
}
