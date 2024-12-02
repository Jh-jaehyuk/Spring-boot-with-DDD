package com.practice.second.player.controller.response_form;

import com.practice.second.dice.entity.Dice;
import com.practice.second.player.service.response.PlayerListResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PlayerListResponseForm {
    private final int id;
    private final String nickname;
    private final List<Dice> diceList;

    public static PlayerListResponseForm from(PlayerListResponse playerListResponse) {
        return new PlayerListResponseForm(
                playerListResponse.getId(),
                playerListResponse.getNickname(),
                playerListResponse.getDiceList()
        );
    }
}
