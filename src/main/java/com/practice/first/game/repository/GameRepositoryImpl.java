package com.practice.first.game.repository;

import com.practice.first.game.entity.Game;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepositoryImpl implements GameRepository {
    int gameCount = 0;

    @Override
    public Game create() {
        int gameId = ++gameCount;
        Game game = new Game(gameId);

        return game;
    }
}
