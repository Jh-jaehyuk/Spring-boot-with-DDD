package com.example.demo.player.repository;

import com.example.demo.player.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {
    static List<Player> playerList = new ArrayList<>();

    final String playerNickname = "player0";
    int playerCount = 0;

    @Override
    public Player create() {
        // nickname을 player01, player02, player03 형태로 만들겠다는 뜻
        String nickname = playerNickname + ++playerCount;
        Player player = new Player(nickname);

        playerList.add(player);

        return player;
    }
}
