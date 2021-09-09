package com.example.chatrooms.controller;

import com.example.chatrooms.domain.Chatroom;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/chatroom")
public class ChatroomController {

    @GetMapping("/{chatroomId}")
    public ResponseEntity<Chatroom> getChatroomById(@PathVariable String chatroomId) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Chatroom> createChatroom(@RequestBody Chatroom chatroom) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{chatroomId}")
    public ResponseEntity<Chatroom> updateChatroom(@PathVariable String chatroomId, @RequestBody Chatroom chatroom) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{chatroomId}")
    public ResponseEntity<Chatroom> deleteChatroom(@PathVariable String chatroomId) {
        return ResponseEntity.ok().build();
    }
}
