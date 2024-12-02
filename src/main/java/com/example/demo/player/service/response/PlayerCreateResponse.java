package com.example.demo.player.service.response;

import com.example.demo.player.entity.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PlayerCreateResponse {
    private final String nickname;
    private final boolean success;

    public static PlayerCreateResponse from(Player player) {
        if (player == null) {
            return new PlayerCreateResponse("", false);
        }

        return new PlayerCreateResponse(player.getNickname(), true);
    }
}