package com.example.springbootlogin.service;


import com.example.springbootlogin.entity.User;
import com.example.springbootlogin.repostory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailChecking{


    @Autowired
    private UserRepo userRepo;


    public  Optional<User> checkEmail(User user){

        Optional<User> user1 = userRepo.findByEmail(user.getEmail());
        return  user1;
    }

}
