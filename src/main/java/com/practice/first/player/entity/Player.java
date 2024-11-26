package com.practice.first.player.entity;

import com.practice.first.dice.entity.Dice;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Player {
    private String nickname;
    private List<Dice> diceList = List.of();

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public String getPlayerNickname() {
        return this.nickname;
    }

    public void setPlayerDiceList(List<Dice> diceList) {
        this.diceList = diceList;
    }

    public Integer getPlayerScore() {
        int playerScore = 0;
        for (Dice dice: this.diceList) {
            playerScore += dice.getDiceNumber();
        }

        return playerScore;
    }
}
