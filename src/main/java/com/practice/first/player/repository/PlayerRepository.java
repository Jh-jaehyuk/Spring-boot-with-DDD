package com.practice.first.player.repository;

import com.practice.first.player.entity.Player;

import java.util.List;

public interface PlayerRepository {
    Player create();
    List<Player> selectTwoPlayers();
}
