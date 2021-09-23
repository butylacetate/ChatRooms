package com.example.chatrooms.controller;

import com.example.chatrooms.domain.Role;

import com.example.chatrooms.domain.User;

import com.example.chatrooms.service.UserService;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("{userId")
    public String getUser(@PathVariable String userId, Model model) {
        model.addAttribute("user", userService.getById(userId));
        return "user";
    }

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("user")
    public String createUser(@RequestParam String username, @RequestParam String password, @RequestParam String role, Model model) {
        model.addAttribute("user", username);
        model.addAttribute("role", role);
        model.addAttribute("password", password);

        return "userEdit";
    }

    @PutMapping("{userId}")
    public String updateUser(@PathVariable String userId, @RequestParam String username, @RequestParam String password, @RequestParam String role, Model model) {
        model.addAttribute("user", userId);
        return "redirect:/user";
    }

    @DeleteMapping("/{userId}")
    public void userDelete(@PathVariable String userId) {
        userService.delete(userId);
    }

    @GetMapping("/{userId}/{blockUserId}")
    public String blockUser(@PathVariable String userId, @PathVariable String blockUserId) {
        userService.block(userId, blockUserId);
        return "user";
    }
    @PutMapping("/{userId}/{switchUserId}")
    public String switchRole (@PathVariable String userId, @PathVariable String switchUserId) {
        userService.switchOn(userId, switchUserId);
        return "user";
    }
}
