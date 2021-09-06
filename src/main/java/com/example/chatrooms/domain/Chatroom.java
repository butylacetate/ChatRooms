package com.example.chatrooms.domain;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "chatroom")
public class Chatroom {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column
    private String id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn (name ="user_id")
    private User owner;

    @Column
    private boolean privat;

    @Column
    private boolean deleted;
}
