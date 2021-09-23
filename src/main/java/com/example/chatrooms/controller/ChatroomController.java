package com.example.chatrooms.controller;

import com.example.chatrooms.domain.Chatroom;
import com.example.chatrooms.domain.Message;
import com.example.chatrooms.service.ChatroomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/chatroom")
public class ChatroomController {

    private final ChatroomService chatroomService;

    @GetMapping("{chatroomId}")
    public String getChatroom(@PathVariable String chatroomId, Model model) {
        model.addAttribute("user", chatroomService.getById(chatroomId));
        return "chatroom";
    }

    @GetMapping("chatroom")
    public String createChatroom(@RequestParam String name, @RequestParam String ownerId, @RequestParam Boolean privat, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("ownerId", ownerId);
        model.addAttribute("privat", privat);
        return "chatroomEdit";
    }

    @PutMapping("{chatroomId}")
    public String updateChatroom(@PathVariable String chatroomId, @RequestParam String name, @RequestParam String ownerId, @RequestParam Boolean privat, Model model) {
        model.addAttribute("chatroom", chatroomId);
        return "redirect:/chatroom";
    }

    @DeleteMapping("/{chatroomId}")
    public void chatroomDelete(@PathVariable String chatroomId) {
        chatroomService.delete(chatroomId);
    }
}
