package com.example.demo.player.controller.response_form;

import com.example.demo.dice.entity.Dice;
import com.example.demo.player.service.response.PlayerCreateResponse;
import com.example.demo.player.service.response.PlayerListResponse;
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