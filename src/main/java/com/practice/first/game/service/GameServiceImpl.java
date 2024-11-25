package com.practice.first.game.service;

import com.practice.first.dice.entity.Dice;
import com.practice.first.dice.repository.DiceRepository;
import com.practice.first.player.entity.Player;
import com.practice.first.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    final private PlayerRepository playerRepository;
    final private DiceRepository diceRepository;

    @Override
    public String play() {
        List<Player> selectedPlayerList = playerRepository.selectTwoPlayers();

        if (selectedPlayerList.size() < 2) {
            return "게임을 플레이하려면 최소 2명의 플레이어가 필요합니다!\n플레이어를 생성하세요.";
        }

        int[] scoreList = {0, 0};
        for (int i = 0; i < 6; i++) {
            Dice dice = diceRepository.rollDice();
            scoreList[i % 2] += dice.getDiceNumber();
        }

        if (scoreList[0] < scoreList[1]) {
            return String.format("%s", selectedPlayerList.get(1).getPlayerNickname());
        }
        else if (scoreList[0] > scoreList[1]) {
            return String.format("%s", selectedPlayerList.get(0).getPlayerNickname());
        }
        else {
            return "DRAW!";
        }
    }
}
