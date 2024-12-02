package com.example.demo.player.service.response;

import com.example.demo.dice.entity.Dice;
import com.example.demo.player.entity.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class PlayerListResponse {
    private final int id;
    private final String nickname;
    private final List<Dice> diceList;

    public static PlayerListResponse from(Player player, List<Dice> diceList) {
        return new PlayerListResponse(player.getId(), player.getNickname(), diceList);
    }
}