package com.example.chatrooms.service;

import com.example.chatrooms.domain.Message;
import com.example.chatrooms.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;


    public Message create(String text, String userId, String chatroomId) {
        return messageRepository.save(Message.builder().text(text).userId(userId).chatroomId(chatroomId).build());
    }


    public Message getById(String id) {
        return messageRepository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
    }

    public Message update(String messageId, String text, String userId, String chatroomId) {
        return messageRepository.save(Message.builder().id(messageId).text(text).userId(userId).chatroomId(chatroomId).build());
    }

    public void delete(String messageId) {
        messageRepository.deleteById(messageId);
    }
}
