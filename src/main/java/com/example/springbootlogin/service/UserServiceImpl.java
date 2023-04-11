package com.example.springbootlogin.service;


import com.example.springbootlogin.entity.Role;
import com.example.springbootlogin.entity.User;
import com.example.springbootlogin.repostory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo ;

    @Override
    public User save(User user) {

        Role role=new Role(2,"ehmed");
        Role role2=new Role(2,"ehmed");



        User newUser=new User(user.getName(), user.getSurname(),user.getPassword(), user.getEmail(), Arrays.asList(role,role2) );

        return userRepo.save(newUser);

    }

    public Optional<User> login(String email, String password){

        Optional<User> user = userRepo.findByEmailAndPassword(email, password);

        return user;

    }
}
