package com.example.chatrooms.domain;

import javax.persistence.*;

import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "chatroom_id")
    private String chatroomId;

    @Column
    private Date datetime;

    @Column
    private String text;
}
