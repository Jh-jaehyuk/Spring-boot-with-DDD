package com.practice.second.game.controller.response_form;

import com.practice.second.game.service.response.CheckGameResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CheckGameResponseForm {
    private final String message;

    public static CheckGameResponseForm from(CheckGameResponse checkGameResponse) {
        return new CheckGameResponseForm(checkGameResponse.getMessage());
    }
}
