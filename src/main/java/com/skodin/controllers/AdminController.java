package com.skodin.controllers;

import com.skodin.models.User;
import com.skodin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String adminPage(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.findAll());
        return "adminPage";
    }

    @PatchMapping("/add")
    public String adminAdd(@ModelAttribute User user){

        System.out.println(user.getId());

        return "redirect:/users";
    }
}
