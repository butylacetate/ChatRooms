package com.example.chatrooms.domain;

public enum Role {
    ADMIN("Администратор"),
    MODERATOR("Модератор"),
    USER("Посетитель"),
    BOT("Бот");

    private String name;

    Role(String name) {
        this.name = name;

    }
}
