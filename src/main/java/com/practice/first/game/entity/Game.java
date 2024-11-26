package com.practice.first.game.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private int gameId;
    private String winner;

    public Game(int gameId) {
        this.gameId = gameId;
    }

    public String getGameWinner() {
        return this.winner;
    }

    public void setGameWinner(String winner) {
        this.winner = winner;
    }
}
