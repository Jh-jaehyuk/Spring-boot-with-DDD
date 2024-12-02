package com.practice.second.player.service.response;

import com.practice.second.dice.entity.Dice;
import com.practice.second.player.entity.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

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
