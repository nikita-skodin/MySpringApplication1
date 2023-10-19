package com.skodin.controllers;

import com.skodin.models.User;
import com.skodin.services.ItemService;
import com.skodin.services.UserService;
import com.skodin.util.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;
    private final ItemService itemService;

    @Autowired
    public UserController(UserService userService, UserValidator userValidator, ItemService itemService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.itemService = itemService;
    }

    @GetMapping()
    public String mainPage(Model model) {

        model.addAttribute("users", userService.findAll());

        return "users/main";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()){
            return "users/new";
        }

        userService.save(user);

        return "redirect:/users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "users/new";
    }

    @GetMapping("{id}")
    public String user(Model model,
                       @PathVariable("id") Integer id) {

        model.addAttribute("user", userService.findOne(id));

        return "users/id";
    }

    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable("id") Integer id) {

        userService.delete(id);

        return "redirect:/users";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model,
                       @PathVariable("id") Integer id){

        model.addAttribute("user", userService.findOne(id));

        return "users/edit";
    }

    @PatchMapping("{id}/update")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult,
                         @PathVariable("id") Integer id){

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()){
            return "users/edit";
        }

        userService.update(id, user);

        return "redirect:/users";
    }



}
