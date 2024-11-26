package com.practice.first.player.repository;

import com.practice.first.player.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {
    static List<Player> playerList = new ArrayList<>();

    final String playerNickname = "player";
    int playerCount = 0;

    @Override
    public Player create() {
        String nickname = playerNickname + ++playerCount;
        Player player = new Player(nickname);

        playerList.add(player);

        return player;
    }

    @Override
    public List<Player> getPlayerList() {
        return playerList;
    }

    @Override
    public List<Player> selectTwoPlayers() {
        int lengthOfPlayerList = playerList.size();

        if (lengthOfPlayerList < 2) {
            return List.of();
        }

        List<Player> gamePlayerList = new ArrayList<>();

        int playerIndex1 = (int)(Math.random() * lengthOfPlayerList) % lengthOfPlayerList;
        int playerIndex2 = (int)(Math.random() * lengthOfPlayerList) % lengthOfPlayerList;
        while (playerIndex2 == playerIndex1) {
            playerIndex2 = (int)(Math.random() * lengthOfPlayerList) % lengthOfPlayerList;
        }

        Player player1 = playerList.get(playerIndex1);
        Player player2 = playerList.get(playerIndex2);

        gamePlayerList.add(player1);
        gamePlayerList.add(player2);

        return gamePlayerList;
    }
}
