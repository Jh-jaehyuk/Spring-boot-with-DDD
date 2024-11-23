package com.example.demo.player.entity;

import lombok.Getter;

@Getter
public class Player {
    private String nickname;

    public Player(String nickname) {
        this.nickname = nickname;
    }
}
