package com.practice.second.player.controller.response_form;

import com.practice.second.player.service.response.PlayerCreateResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PlayerCreateResponseForm {
    private final String nickname;
    private final boolean success;

    public static PlayerCreateResponseForm from(PlayerCreateResponse playerCreateResponse) {
        return new PlayerCreateResponseForm(playerCreateResponse.getNickname(), playerCreateResponse.isSuccess());
    }
}
