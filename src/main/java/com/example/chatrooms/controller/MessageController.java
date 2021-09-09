package com.example.chatrooms.controller;

import com.example.chatrooms.domain.Message;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/message")
public class MessageController {

    @GetMapping("/{messageId}")
    public ResponseEntity<Message> getMessageById(@PathVariable String messageId) {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Message> createUser(@RequestBody Message message) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{messageId}")
    public ResponseEntity<Message> updateUser(@PathVariable String messageId, @RequestBody Message message) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{messageId}")
    public ResponseEntity<Message> deleteUser(@PathVariable String messageId) {
        return ResponseEntity.ok().build();
    }
}
