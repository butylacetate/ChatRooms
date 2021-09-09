package com.example.chatrooms.repository;

import com.example.chatrooms.domain.Chatroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatroomRepository extends JpaRepository<Chatroom, String> {
}
