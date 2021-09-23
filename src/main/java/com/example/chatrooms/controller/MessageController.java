package com.example.chatrooms.controller;

import com.example.chatrooms.domain.Message;
import com.example.chatrooms.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    @GetMapping("{messageId}")
    public String getMessage(@PathVariable String messageId, Model model) {
        model.addAttribute("user", messageService.getById(messageId));
        return "message";
    }

    @GetMapping("message")
    public String createMessage(@RequestParam String text, @RequestParam String userId, @RequestParam String chatroomId, Model model) {
        model.addAttribute("text", text);
        model.addAttribute("userId", userId);
        model.addAttribute("chatroomId", chatroomId);

        return "messageEdit";
    }

    @PutMapping("{messageId}")
    public String updateMessage(@PathVariable String messageId, @RequestParam String text, @RequestParam String userId, @RequestParam String chatroomId, Model model) {
        model.addAttribute("message", messageId);
        return "redirect:/message";
    }

    @DeleteMapping("/{messageId}")
    public void messageDelete(@PathVariable String messageId) {
        messageService.delete(messageId);
    }
}
