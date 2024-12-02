package com.practice.second.player.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nickname;
    private List<Long> diceIdList;

    public Player(String nickname) {
        this.nickname = nickname;
        this.diceIdList = new ArrayList<>();
    }

    public void addDiceId(Long diceId) {
        this.diceIdList.add(diceId);
    }

    public Player() {}
}
