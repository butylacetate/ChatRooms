package com.example.chatrooms.service;

import com.example.chatrooms.domain.Message;
import com.example.chatrooms.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;


    public Message create(Message message) {
        return messageRepository.save(message);
    }


    public Message getById(String id) {
        return messageRepository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
    }

    public Message update(Message message) {
        return messageRepository.save(message);
    }

    public void delete(String messageId) {
        messageRepository.deleteById(messageId);
    }
}
