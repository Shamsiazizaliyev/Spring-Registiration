package com.example.springbootlogin.controller;


import com.example.springbootlogin.entity.User;
import com.example.springbootlogin.service.EmailChecking;
import com.example.springbootlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class UserController {



    @Autowired
    private EmailChecking emailChecking;
    @Autowired
    private UserService userService;

    @GetMapping("/rg")

    public String  resgisterationPage(Model model){

        model.addAttribute("user",new User());

        return "registration";
    }

    @PostMapping("/registerNew")

    public String register(User user){

        Optional<User> user1 = emailChecking.checkEmail(user);

        if(user1.isPresent()){
            return "redirect:rg?eyni";
        }

        userService.save(user);
        return "redirect:rg?success";


    }

    @GetMapping ("/loginPage")
    public String loginPage(){


        return "login";


    }

    @PostMapping ("/login")
    public String loginToWebsite(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest servletRequest){

        Optional<User> user = userService.login(email, password);
        if(!user.isPresent()){
            model.addAttribute("error","User not found  ");

            return "login";
        }
        model.addAttribute("user",user);
        servletRequest.getSession().setAttribute("istifadeci",user.get());

        return "welcome";


    }

    @GetMapping("/welcome")
    public String welcome(HttpServletRequest servletRequest,Model model){
     User user = (User) servletRequest.getSession().getAttribute("istifadeci");
     model.addAttribute("user",user);

     if(user==null){
         return "login";
     }
        return "welcome";
    }

    @GetMapping("/logout")

    public String logout(HttpServletRequest servletRequest , Model model){
        servletRequest.getSession().invalidate();
        model.addAttribute("logout"," siz ugurla sistemden cixis etdiniz");
        return "login";
        
    }

}
