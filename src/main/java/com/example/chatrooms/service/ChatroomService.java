package com.example.chatrooms.service;

import com.example.chatrooms.domain.Chatroom;
import com.example.chatrooms.repository.ChatroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ChatroomService {
    private final ChatroomRepository chatroomRepository;

    public Chatroom create(String name, String ownerId, boolean privat) {
        return chatroomRepository.save(Chatroom.builder().name(name).ownerId(ownerId).privat(privat).build());
    }

    public Chatroom getById(String id) {
        return chatroomRepository.findById(id).orElseThrow(() -> new RuntimeException("Chatroom not found"));
    }

    public Chatroom update(String chatroomId, String name, String ownerId, boolean privat) {
        return chatroomRepository.save(Chatroom.builder().id(chatroomId).name(name).ownerId(ownerId).privat(privat).build());
    }

    public void delete(String chatroomId) {
        chatroomRepository.deleteById(chatroomId);
    }
}
