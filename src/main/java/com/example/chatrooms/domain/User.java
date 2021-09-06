package com.example.chatrooms.domain;


import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column
    private long id;

    @Column
    private String username;

    @Column
    private String password;

    @OneToOne
    @JoinColumn (name ="role_id")
    private Role role;

    @Column
    private boolean blocked;

    @ManyToMany
    @JoinTable (
        name="users_and_chatrooms",
        joinColumns = {@JoinColumn(name="user_id")},
        inverseJoinColumns ={@JoinColumn(name="chatroom_id")}
    )
    private Set<Chatroom> chatrooms = new HashSet<>();

}
