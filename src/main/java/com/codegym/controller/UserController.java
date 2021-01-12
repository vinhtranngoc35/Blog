package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView getViewRegister(){
        return new ModelAndView("register","user",new User());
    }
    @PostMapping("/register")
    public String createUser(@ModelAttribute("user") User user, Model model){
        //Ma hoa password

        User userCheck = userService.findByUserName(user.getUsername());
        if(userCheck!=null){
            model.addAttribute("message", "User name already exists");
            model.addAttribute("user",user);


            return "register";
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRole("USER");
        user.setEnable(1);
        userService.save(user);
        System.out.println(user.getUsername());
        return "redirect:/login";
    }
}
