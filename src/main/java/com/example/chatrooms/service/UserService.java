package com.example.chatrooms.service;

import com.example.chatrooms.domain.User;
import com.example.chatrooms.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    public User create(User user) {
        return userRepository.save(user);
    }

    public User getById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User update(User user) {
         return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}

