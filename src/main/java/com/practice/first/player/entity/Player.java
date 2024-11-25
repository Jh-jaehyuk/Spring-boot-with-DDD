package com.practice.first.player.entity;

import lombok.Getter;

@Getter
public class Player {
    private String nickname;

    public Player(String nickname, Integer score) {
        this.nickname = nickname;
    }

    public String getPlayerNickname() {
        return this.nickname;
    }
}
