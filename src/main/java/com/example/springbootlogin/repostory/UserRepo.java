package com.example.springbootlogin.repostory;


import com.example.springbootlogin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {



    Optional<User> findByEmailAndPassword(String email, String password );

    Optional<User> findByEmail(String email);

}
