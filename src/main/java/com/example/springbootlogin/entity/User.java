package com.example.springbootlogin.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer id;

    private  String  name;
    private  String  surname;
    private  String  password;
    private  String  email;

    public User(String name, String surname, String password, String email, List<Role> roleList) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.roleList = roleList;
    }



    @ManyToMany
    @JoinTable(name = "UserAndRole",
            joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id")


    )
    private List<Role> roleList;
}
