package com.example.chatrooms.service;

import com.example.chatrooms.domain.Chatroom;
import com.example.chatrooms.repository.ChatroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ChatroomService {
    private final ChatroomRepository chatroomRepository;

    public Chatroom create(Chatroom chatroom) {
        return chatroomRepository.save(chatroom);
    }

    public Chatroom getById(String id) {
        return chatroomRepository.findById(id).orElseThrow(() -> new RuntimeException("Chatroom not found"));
    }

    public Chatroom update(Chatroom chatroom) {
        return chatroomRepository.save(chatroom);
    }

    public void delete(String chatroomId) {
        chatroomRepository.deleteById(chatroomId);
    }
}
