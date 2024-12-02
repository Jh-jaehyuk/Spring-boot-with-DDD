package com.practice.second.game.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private List<Long> playerIdList;
    private int winnerId;

    public Game(List<Long> playerIdList) {
        this.playerIdList = playerIdList;
    }

    public Game() {}
}
