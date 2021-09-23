package com.example.chatrooms.service;

import com.example.chatrooms.domain.Role;
import com.example.chatrooms.domain.User;
import com.example.chatrooms.repository.UserRepository;
import liquibase.pro.packaged.E;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class UserService {


    private final UserRepository userRepository;


    public User create(String username, String password, String role) {
        return userRepository.save(User.builder().username(username).password(password).role(Role.valueOf(role)).build());
    }

    public User getById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User update(String userId, String username, String password, String role) {
        return userRepository.save(User.builder().id(userId).username(username).password(password).role(Role.valueOf(role)).build());
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void block(String userId, String blockUserId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new RuntimeException(String.format("user with userId = %s doesnt exist", userId));
        }
        if (user.get().getRole().equals(Role.ADMIN) || user.get().getRole().equals(Role.MODERATOR)) {
            Optional<User> blockUser = userRepository.findById(blockUserId);
            if (!blockUser.isPresent()) {
                throw new RuntimeException(String.format("user with userId = %s doesnt exist", blockUserId));
            }

            blockUser.get().setBlocked(!blockUser.get().isBlocked());
            userRepository.save(blockUser.get());
        }
    }

    public void switchOn(String userId, String switchUserId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new RuntimeException(String.format("user with userId = %s doesnt exist", userId));
        }
        if (user.get().getRole().equals(Role.ADMIN)) {
            Optional<User> switchUser = userRepository.findById(switchUserId);
            if (!switchUser.isPresent()) {
                throw new RuntimeException(String.format("user with userId = %s doesnt exist", switchUserId));
            }

            if (switchUser.get().getRole().equals(Role.USER)) {
                switchUser.get().setRole(Role.MODERATOR);
            } else {
                switchUser.get().setRole(Role.USER);
            }
            userRepository.save(switchUser.get());
        }
    }

}

