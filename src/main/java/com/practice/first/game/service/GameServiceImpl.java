package com.practice.first.game.service;

import com.practice.first.dice.entity.Dice;
import com.practice.first.dice.repository.DiceRepository;
import com.practice.first.game.entity.Game;
import com.practice.first.game.repository.GameRepository;
import com.practice.first.player.entity.Player;
import com.practice.first.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    final private GameRepository gameRepository;
    final private PlayerRepository playerRepository;
    final private DiceRepository diceRepository;

    @Override
    public Game createGame() {
        return gameRepository.create();
    }

    @Override
    public String play() {
        List<Player> selectedPlayerList = playerRepository.selectTwoPlayers();

        if (selectedPlayerList.size() < 2) {
            return "게임을 플레이하려면 최소 2명의 플레이어가 필요합니다!\n플레이어를 생성하세요.";
        }

        List<Dice> nowDiceList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Dice dice = diceRepository.rollDice();
            nowDiceList.add(dice);
        }
        Player player1 = selectedPlayerList.getFirst();
        player1.setPlayerDiceList(nowDiceList);

        nowDiceList.clear();
        for (int i = 0; i < 3; i++) {
            Dice dice = diceRepository.rollDice();
            nowDiceList.add(dice);
        }
        Player player2 = selectedPlayerList.getLast();
        player2.setPlayerDiceList(nowDiceList);

        int score1 = player1.getPlayerScore();
        int score2 = player2.getPlayerScore();

        if (score1 < score2) {
            return String.format("%s", selectedPlayerList.getLast().getPlayerNickname());
        }
        else if (score1 > score2) {
            return String.format("%s", selectedPlayerList.getFirst().getPlayerNickname());
        }
        else {
            return "DRAW!";
        }
    }
}
