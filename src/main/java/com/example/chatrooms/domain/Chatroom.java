package com.example.chatrooms.domain;
import javax.persistence.*;

import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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

    @Column(name = "owner_id")
    private String ownerId;

    @Column
    private boolean privat;

    @Column
    private boolean deleted;
}
