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
        chatroomService.create(Chatroom.builder().name(name).ownerId(ownerId).privat(privat).build());
        return "chatroomEdit";
    }

    @PutMapping("{chatroomId}")
    public String updateChatroom(@PathVariable String chatroomId, @RequestParam String name, @RequestParam String ownerId, @RequestParam Boolean privat, Model model) {
        model.addAttribute("chatroom", chatroomService.update(Chatroom.builder().id(chatroomId).name(name).ownerId(ownerId).privat(privat).build()));
        return "redirect:/chatroom";
    }

    @DeleteMapping("/{chatroomId}")
    public void chatroomDelete(@PathVariable String chatroomId) {
        chatroomService.delete(chatroomId);
    }
}
