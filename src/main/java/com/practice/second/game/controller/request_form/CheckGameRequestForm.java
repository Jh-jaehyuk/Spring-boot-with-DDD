package com.practice.second.game.controller.request_form;

import com.practice.second.game.service.request.CheckGameRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CheckGameRequestForm {
    private final Long gameId;

    public CheckGameRequest toCheckGameRequest() {
        return new CheckGameRequest(this.gameId);
    }
}
