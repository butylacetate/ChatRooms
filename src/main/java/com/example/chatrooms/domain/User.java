package com.example.chatrooms.domain;


import javax.persistence.*;

import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column
    private String id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Role role;

    @Column
    private boolean blocked;

    @ManyToMany
    @JoinTable(
            name = "users_and_chatrooms",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "chatroom_id")}
    )
    private Set<Chatroom> chatrooms = new HashSet<>();

}
