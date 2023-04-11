package com.example.springbootlogin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootLoginApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLoginApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("salam");

    }
}
